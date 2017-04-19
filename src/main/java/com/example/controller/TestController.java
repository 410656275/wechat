package com.example.controller;

import com.example.entity.Result;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cc on 17-4-13.
 */
@RestController
public class TestController {

    @PostMapping("test")
    public Result test(@RequestBody String[] opened_list){

        Gson gson = new Gson();
        System.out.println(gson.toJson(opened_list));
        return null;
    }

    public static void main(String[] args) {

    }
}
