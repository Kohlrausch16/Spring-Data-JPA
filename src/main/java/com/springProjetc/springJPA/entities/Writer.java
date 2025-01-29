package com.springProjetc.springJPA.entities;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

@Entity
@Table(name = "writer")
@Getter
@Setter
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false)
    private String nationality;

    @Deprecated
    public Writer(){

    }

    public Writer(String name, Date birthdate, String nationality) {
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
    }

    @OneToMany
    @
    private Set<Book> books;
}
