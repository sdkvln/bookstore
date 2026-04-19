package com.evelina.bookstore.service.Impl;

import org.springframework.stereotype.Service;

import com.evelina.bookstore.dto.BookDto;
import com.evelina.bookstore.entity.Book;
import com.evelina.bookstore.entity.Work;
import com.evelina.bookstore.entity.enums.BookStatus;
import com.evelina.bookstore.exception.BookNotAvailableException;
import com.evelina.bookstore.exception.ResourceNotFoundException;
import com.evelina.bookstore.mapper.BookMapper;
import com.evelina.bookstore.repository.BookRepository;
import com.evelina.bookstore.repository.WorkRepository;
import com.evelina.bookstore.service.BookService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
    private BookRepository bookRepository;
    private final WorkRepository workRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Work work = workRepository.findById(bookDto.getWorkId()).orElseThrow(() -> new ResourceNotFoundException("Нет книги с идентификатором: " + bookDto.getWorkId()));

        Book book = new Book();
        book.setIsbn(bookDto.getIsbn());
        book.setPublisher(bookDto.getPublisher());
        book.setYear(bookDto.getYear());
        book.setPrice(bookDto.getPrice());
        book.setStatus(BookStatus.AVAILABLE);
        book.setWork(work);
        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }

    @Override
    @Transactional
    public BookDto reserveBook(Long bookId) {
        Book book=bookRepository.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Нет книги с идентификатором: "+bookId));
        
        if(book.getStatus() != BookStatus.AVAILABLE){
            throw new BookNotAvailableException("Книга недоступна для бронирования");
        }

        book.setStatus(BookStatus.RESERVED);

        return BookMapper.mapToBookDto(book);
    }
    
}
