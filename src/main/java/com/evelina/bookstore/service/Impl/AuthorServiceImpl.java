package com.evelina.bookstore.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evelina.bookstore.dto.AuthorDto;
import com.evelina.bookstore.dto.BookDto;
import com.evelina.bookstore.entity.Author;
import com.evelina.bookstore.entity.Work;
import com.evelina.bookstore.exception.ResourceNotFoundException;
import com.evelina.bookstore.mapper.AuthorMapper;
import com.evelina.bookstore.mapper.BookMapper;
import com.evelina.bookstore.repository.AuthorRepository;
import com.evelina.bookstore.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());

        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.mapToAuthorDto(savedAuthor);
    }

    @Override
    public AuthorDto getAuthorById(Long authorId) {
        Author author=authorRepository.findById(authorId).orElseThrow(()->new ResourceNotFoundException("Нет автора с идентификатором: " + authorId));
        return AuthorMapper.mapToAuthorDto(author);
    }

    @Override
    public List<BookDto> getBooksByAuthorId(Long authorId) {
        Author author=authorRepository.findById(authorId).orElseThrow(()->new ResourceNotFoundException("Нет автора с идентификатором: " + authorId));
        List<Work> works=author.getWorks();
        return works.stream().flatMap(work -> work.getBooks().stream()).map((book)->BookMapper.mapToBookDto(book)).toList();

    }

}
