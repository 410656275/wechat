package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 接口请求aop
 * Created by cc on 17-4-12.
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();
    private String name;

    @Pointcut("execution(* com.example.controller..*.*(..)) ")
    public void log(){}

    @Before(value="log()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        startTime.set(System.currentTimeMillis());
        // 记录下请求内容
//        logger.info("URL : " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.info("IP : " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        name=joinPoint.getSignature().getName();
        logger.info("[apo]["+joinPoint.getSignature().getName()+":接口请求前]");
    }

//    @After( value = "log()")
//    public void afterAdvice (){
//        logger.info("After : ");
//    }

//    @AfterThrowing(throwing="ex",pointcut="log()")
//    public void test(Throwable ex){
//        logger.info("AfterThrowing : " + ex.getMessage());
//    }

    @AfterReturning(pointcut = "log()")
    public void doAfterReturning(){
//        logger.info("AfterReturning : " + result);
        logger.info("[aop]["+name+":接口请求时间: " + (System.currentTimeMillis() - startTime.get())+"ms");
    }



}
