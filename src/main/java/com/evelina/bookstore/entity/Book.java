package com.evelina.bookstore.entity;

import com.evelina.bookstore.entity.enums.BookStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="book_number", unique = true, nullable = false)
    private String isbn;
    @Column(name="publisher", nullable = false)
    private String publisher;
    @Column(name="year",nullable = false)
    private int year;
    @Column(name="price",nullable = false)
    private double price;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Version
    private Long version;
    @ManyToOne
    private Work work;
}
