package com.drafire.user.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    private static final long serialVersionUID = 7813643955858537112L;
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

    @Override
    public String toString() {
        return "LoginRequest{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
