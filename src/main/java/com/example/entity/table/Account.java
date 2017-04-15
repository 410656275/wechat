package com.example.entity.table;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * Created by cc on 17-4-5.
 */
@Entity
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String accountName;

    private String appid;

    private String secret;

    private String token;

    private boolean enable=true;

}
