package com.capgemini.heskuelita.core.beans;

import lombok.Data;

@Data
public abstract class Person {

    public String userName;
    public String password;
    public String email;

    public Person() {
    }

}
