package com.evelina.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evelina.bookstore.dto.AuthorDto;
import com.evelina.bookstore.dto.BookDto;
import com.evelina.bookstore.service.AuthorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private AuthorService authorService;
    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto authorDto) {
        AuthorDto savedAuthor = authorService.createAuthor(authorDto);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("id")Long authorId){
        AuthorDto authorDto=authorService.getAuthorById(authorId);
        return ResponseEntity.ok(authorDto);
    }

    @GetMapping("{id}/books")
    public ResponseEntity<List<BookDto>> getBooksByAuthorId(@PathVariable("id")Long authorId){
        List<BookDto> books=authorService.getBooksByAuthorId(authorId);
        return ResponseEntity.ok(books);
    }
}
