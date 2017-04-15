package com.example.controller;

import com.example.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cc on 17-4-13.
 */
@RestController
public class WXTestController {

    @GetMapping("{appid}/test")
    public Result test(@PathVariable String appid,String psw, String name,  HttpServletRequest request){

        System.out.println(request.getAttribute("aaa"));
        return null;
    }
}
