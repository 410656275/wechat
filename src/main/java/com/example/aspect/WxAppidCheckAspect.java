package com.example.aspect;

import com.example.constants.WxErrorCode;
import com.example.constants.WxParams;
import com.example.entity.table.Account;
import com.example.exception.MyException;
import com.example.service.WXCheckAppidService;
import com.example.service.WXTokenService;
import com.example.utils.ResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 微信接口请求appid参数验证aop
 * Created by cc on 17-4-13.
 */
@Aspect
@Component
public class WxAppidCheckAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private WXCheckAppidService wxCheckAppidService;
    @Autowired private WXTokenService wxTokenService;

    @Pointcut("execution(* com.example.controller.WX*.*(..))&& !execution(* com.example.controller.WXTokenController.getAppidBySecret(..))")
    public void log(){}

    @Before(value="log()")
    public void doBefore(JoinPoint joinPoint) throws IOException {

        //1.验证appid合法性
        Object[] list = joinPoint.getArgs();
        String appid = (String) list[0];
        Account account = wxCheckAppidService.check(appid);
        if (account!=null) {
            //2.通过验证-->查询token
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            String token = wxTokenService.getToken(appid);
            if (token != null) {
                //缓存拿token
                logger.info("[aop][缓存中获取token]");
                request.setAttribute(WxParams.ACCESS_TOKEN,token);
            } else {
                //新取token
                logger.info("[aop][重新获取token]");
                request.setAttribute(WxParams.ACCESS_TOKEN,wxTokenService.getTokenSecret(appid,account.getSecret()));
            }
        }else{
            logger.warn("appid:"+appid+"请求操作"+joinPoint.getSignature().getName()+"接口无效");
            throw new MyException(WxErrorCode.SYS_ERROR_PARAMS_APPID);
        }
    }

//    @Around(value="log()")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("===============");
//        Object[] list = pjp.getArgs();
//        String appid = (String) list[0];
//        logger.info(appid+":不合法");
//
//        return pjp.proceed();
////        Result result = new Result();
////        result.setCode(-1);
////        return result;
//    }
}
