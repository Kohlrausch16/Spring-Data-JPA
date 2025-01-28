package com.springProjetc.springJPA.entities;

import jakarta.persistence.*;
import java.util.*;
import com.springProjetc.springJPA.entities.enums.BookKind;
import lombok.*;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Date releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookKind kind;

    @Column(nullable = false)
    private Double price;

    @Deprecated
    public Book(){

    }

    public Book(String isbn, String title, Date releaseDate, BookKind kind, Double price, Writer writer) {
        this.isbn = isbn;
        this.title = title;
        this.releaseDate = releaseDate;
        this.kind = kind;
        this.price = price;
        this.writer = writer;
    }

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;
}
