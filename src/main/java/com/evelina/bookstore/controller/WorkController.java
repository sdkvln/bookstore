package com.evelina.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evelina.bookstore.dto.WorkDto;
import com.evelina.bookstore.service.WorkService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/works")
public class WorkController {
    private WorkService workService;

    @PostMapping
    public ResponseEntity<WorkDto> createWork(@Valid @RequestBody WorkDto workDto){
        WorkDto savedWork=workService.createWork(workDto);
        return new ResponseEntity<>(savedWork, HttpStatus.CREATED);
    }
}
