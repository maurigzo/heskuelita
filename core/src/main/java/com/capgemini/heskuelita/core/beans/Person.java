package com.capgemini.heskuelita.core.beans;

import lombok.Data;

@Data
public abstract class Person {

    public String user_name;
    public String password;
    public String email;

    public Person() {
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
