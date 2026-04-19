package com.evelina.bookstore.service.Impl;

import org.springframework.stereotype.Service;

import com.evelina.bookstore.dto.WorkDto;
import com.evelina.bookstore.entity.Author;
import com.evelina.bookstore.entity.Work;
import com.evelina.bookstore.exception.ResourceNotFoundException;
import com.evelina.bookstore.mapper.WorkMapper;
import com.evelina.bookstore.repository.AuthorRepository;
import com.evelina.bookstore.repository.WorkRepository;
import com.evelina.bookstore.service.WorkService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class WorkServiceImpl implements WorkService{
    private WorkRepository workRepository;
    private final AuthorRepository authorRepository;
    @Override
    public WorkDto createWork(WorkDto workDto) {
        Author author = authorRepository.findById(workDto.getAuthorId()).orElseThrow(() -> new ResourceNotFoundException("Нет автора с идентификатором: " + workDto.getAuthorId()));

        Work work = new Work();
        work.setTitle(workDto.getTitle());
        work.setAuthor(author);

        Work savedWork = workRepository.save(work);

        return WorkMapper.maptoWorkDto(savedWork);

    }
    
}
