package com.model;

public class LoginBean {
    private String username;
    private String password;

    public LoginBean() {}

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

    public boolean validate() {
        // Hardcoded for demo; you can later connect to DB
        return "admin".equals(username) && "1234".equals(password);
    }
}
