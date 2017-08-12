package com.paulosilva.cwebservice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulo Silva on 08/01/2017.
 */

class Users extends ArrayList<Users>{
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String authKey;
    private String accessToken;
    private String activate;
    private int role;
    private String lastChangePassword;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLastChangePassword() {
        return lastChangePassword;
    }

    public void setLastChangePassword(String lastChangePassword) {
        this.lastChangePassword = lastChangePassword;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", authKey='" + authKey + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", activate='" + activate + '\'' +
                ", role=" + role +
                ", lastChangePassword=" + lastChangePassword +
                '}';
    }
}
