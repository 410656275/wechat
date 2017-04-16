package com.example.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * Created by cc on 2017/4/15 0015.
 */
public class CommonDto {

    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
