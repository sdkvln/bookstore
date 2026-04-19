package com.evelina.bookstore.service;

import java.util.List;

import com.evelina.bookstore.dto.AuthorDto;
import com.evelina.bookstore.dto.BookDto;

public interface AuthorService {

    AuthorDto createAuthor(AuthorDto authorDto);
    
    AuthorDto getAuthorById(Long authorId);

    List<BookDto> getBooksByAuthorId(Long authorId);
}
