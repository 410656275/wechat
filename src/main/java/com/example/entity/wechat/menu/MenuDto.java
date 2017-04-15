package com.example.entity.wechat.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vobile on 16-6-17.
 */
@Data
public class MenuDto implements Serializable {

    private List<Button> button;

    public String toGson(){
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        return gson.toJson(this);
    }
}
