package com.example.entity.table;

import com.example.entity.CommonDto;
import lombok.Data;

import javax.persistence.*;

/**
 *
 * Created by cc on 17-4-21.
 */
@Entity
@Data
@Table(name = "user_info")
public class AliUser extends CommonDto{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String aliname;
    @Column(name ="img")
    private String aliimg;

}
