package com.evelina.bookstore.service;

import com.evelina.bookstore.dto.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto reserveBook(Long bookId);
}
