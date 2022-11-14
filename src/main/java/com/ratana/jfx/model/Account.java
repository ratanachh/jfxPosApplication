package com.ratana.jfx.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
public class Account {
    @Id
    private String username;
    private String name;
    private Role role;
    private String password;

    public enum Role {
        Admin, Sale, Purchase
    }
}
