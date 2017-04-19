package com.example.controller;

import com.example.entity.Result;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}
