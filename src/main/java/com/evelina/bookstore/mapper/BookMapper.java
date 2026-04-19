package com.evelina.bookstore.mapper;

import com.evelina.bookstore.dto.BookDto;
import com.evelina.bookstore.entity.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book){
        return new BookDto(
            book.getId(),
            book.getIsbn(),
            book.getWork().getTitle(),
            book.getPublisher(),
            book.getYear(),
            book.getPrice(),
            book.getStatus().name(),
            book.getWork().getId()
        );
    }
}
