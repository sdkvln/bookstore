package com.evelina.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evelina.bookstore.dto.BookDto;
import com.evelina.bookstore.service.BookService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;
    @PostMapping
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto){
        BookDto savedBook=bookService.createBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/reserve")
    public ResponseEntity<BookDto> reserveBook(@PathVariable("id")Long bookId){
        BookDto reservedBook=bookService.reserveBook(bookId);
        return ResponseEntity.ok(reservedBook);
    }
}
