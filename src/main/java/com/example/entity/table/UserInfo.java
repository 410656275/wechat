package com.example.entity.table;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cc on 17-4-10.
 */

@Entity
@Data
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String img;
}
