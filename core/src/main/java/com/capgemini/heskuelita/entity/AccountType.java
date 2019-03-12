package com.capgemini.heskuelita.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "AccountType")
@Table(name = "account_type")
public class AccountType {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO, generator = "product_type_seq")
    @SequenceGenerator (name = "product_type_seq", sequenceName = "product_type_seq")
    @Column(name = "id")
    private Long id;

    @Column (name="type_name", length = 40, nullable = false)
    private String type_name;

    @OneToMany (mappedBy = "account_type")
    private Set<Account> accounts = new HashSet<>();

    public AccountType(String type_name) {
        this.type_name = type_name;
    }

    public AccountType(String type_name, Set<Account> accounts) {
        this.type_name = type_name;
        this.accounts = accounts;
    }

    public AccountType() {
    }
}
