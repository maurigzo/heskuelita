package com.capgemini.heskuelita.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Data
@Entity(name =  "Human")
@Table(name = "human")
public class Human {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO, generator = "human_seq")
    @SequenceGenerator(name = "human_seq", sequenceName = "human_seq")
    @Column (name="id", nullable=false, unique=true)
    private int id;

    @Column (name="user_name", length = 40, nullable=false, unique=true)
    private String user_name;

    @Column(name="password", length=40, nullable=false)
    private String password;

    @Column(name="email", length=40, nullable=false)
    private String email;




    public Human(String user_name, String password, String email) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
    }

    public Human() {
    }
}
