package com.chiyi.user.entity;

public class UserEntity {
    private int id;
    private String account;
    private String name;
    private String password;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity() {
    }

    public UserEntity(int id, String account, String name, String password, String email) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UserEntity(String account, String name, String password, String email) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
