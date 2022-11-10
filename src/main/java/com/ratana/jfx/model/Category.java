package com.ratana.jfx.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @SequenceGenerator(
            name = "category_sequence",
            allocationSize = 1
    )
    private int id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
