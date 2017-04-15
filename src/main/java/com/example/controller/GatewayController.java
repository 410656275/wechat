package com.example.controller;

import com.example.config.WXConfig;
import com.example.constants.WxParams;
import com.example.service.WXGatewayService;
import com.example.utils.HashText;
import com.example.utils.WXUtils;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

/**
 * 网关
 * Created by cc on 17-2-13.
 */
@RestController
public class GatewayController {

    private static final Logger logger = LoggerFactory.getLogger(GatewayController.class);

    @Autowired WXConfig wxConfig;

    @Autowired WXGatewayService wxGatewayService;

    /**
     * 微信网关验证
     * @param requset
     * @param response
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @GetMapping("gateway")
    public void wechatCheck(HttpServletRequest requset, HttpServletResponse response) throws NoSuchAlgorithmException, IOException {

        String signature = requset.getParameter(WxParams.SIGNATURE);
        String timestamp = requset.getParameter(WxParams.TIMESTAMP);
        String nonce = requset.getParameter(WxParams.NONCE);
        String echostr = requset.getParameter(WxParams.ECHOSTR);
        String[] str = {wxConfig.getToken(), timestamp, nonce};
        Arrays.sort(str);
        String digest = new HashText().sha1(str[0] + str[1] + str[2]).toLowerCase();
        if (digest.equals(signature)) {
            response.getWriter().print(echostr);
        }
    }

    /**
     * 微信网关交互
     * @param requset
     * @param response
     * @throws IOException
     * @throws DocumentException
     */
    @PostMapping("gateway")
    public void wechatResponse(HttpServletRequest requset, HttpServletResponse response) throws IOException, DocumentException {
        PrintWriter out;
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> map = WXUtils.xmlToMap(requset);
        JSONObject jsonObject = JSONObject.fromObject(map);
        //格式化输出日志
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            logger.info("[微信网关][请求内容]\n"+gson.toJson(jsonObject));
        logger.info("[微信网关][请求内容]\n" + jsonObject);
        String result = wxGatewayService.getResp(jsonObject);
        logger.info("[微信网关][回复内容]\n" + result);
        out = response.getWriter();
        out.write(result);
        response.flushBuffer();
    }
}
