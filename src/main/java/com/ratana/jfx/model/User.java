package com.ratana.jfx.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
}
