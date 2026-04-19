package com.evelina.bookstore.mapper;

import com.evelina.bookstore.dto.AuthorDto;
import com.evelina.bookstore.entity.Author;

public class AuthorMapper {
    public static AuthorDto mapToAuthorDto(Author author){
        return new AuthorDto(
            author.getId(),
            author.getFirstName(),
            author.getLastName()
        );
    }
}
