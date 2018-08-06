package com.yangyang.dto;

import lombok.Data;

/**
 * Created by Administrator on 2018/7/22.
 */
@Data
public class User {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
