package com.example.entity.wechat.menu;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vobile on 16-6-17.
 */
@Data
public class Button implements Serializable {
    private String type;
    private String name;
    private String key;
    private String url;
    private List<SubButton> sub_button;

}
