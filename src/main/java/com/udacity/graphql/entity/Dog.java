package com.udacity.graphql.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@Table(name = "DOG")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dogid")
    private Long id;

    private String name;
    private String breed;
    private String origin;
}
