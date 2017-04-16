package com.example.entity.wechat.tag;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

/**
 *
 * Created by cc on 2017/4/15 0015.
 */
@Data
public class TagDto {
    private Tag tag;

    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
