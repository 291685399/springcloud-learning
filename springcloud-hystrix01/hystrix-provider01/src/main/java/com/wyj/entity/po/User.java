package com.wyj.entity.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String sex;
    private int age;
    private String address;
    private String phone;

}
