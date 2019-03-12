package com.capgemini.heskuelita.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Data
@Entity(name =  "Account")
@Table(name ="account")
public class Account {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq")
    @Column (name="id", nullable=false, unique=true)
    private Long id;

    @Column (name="user_name", length = 40, nullable=false)
    private String user_name;

    @Column(name="password", length=40, nullable=false)
    private String password;

    @Column(name="email", length=40, nullable=false)
    private String email;


    public Account() {
    }

    public Account(String user_name, String password, String email) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
    }
}
