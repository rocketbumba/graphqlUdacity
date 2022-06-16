package com.udacity.Graphql.entity;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOGID")
    private long dogid;

    private String name;
    private String breed;
    private String origin;

    public Dog(long dogid, String name, String breed, String origin) {
        this.dogid = dogid;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }
}
