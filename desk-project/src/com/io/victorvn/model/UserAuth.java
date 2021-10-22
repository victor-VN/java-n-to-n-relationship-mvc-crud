package com.io.victorvn.model;

public class UserAuth {

    private int id;
    private String username;
    private String email;
    private String passwordUsr;

    public UserAuth() {
    }

    public UserAuth(int id, String username, String email, String passwordUsr) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordUsr = passwordUsr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPasswordUsr() {
        return passwordUsr;
    }

    public void setPasswordUsr(String passwordUsr) {
        this.passwordUsr = passwordUsr;
    }
}
