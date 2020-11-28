package com.example.myproyectem8_2;

public class Users {
    private String username = "admin";//admin
    private String password = "admin";//admin

    public Users(){}

    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
