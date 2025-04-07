package com.example.vicontred.model;

public class Password {
    private Long id;
    private String password;
    private String passwordViejo;
    private String regSecurity;
    private User user;

    public Password() {
    }

    public Password(String password, User user) {
        this.password = password;
        this.passwordViejo = password;
        this.regSecurity = null;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordViejo() {
        return passwordViejo;
    }

    public void setPasswordViejo(String passwordViejo) {
        this.passwordViejo = passwordViejo;
    }

    public String getRegSecurity() {
        return regSecurity;
    }

    public void setRegSecurity(String regSecurity) {
        this.regSecurity = regSecurity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
