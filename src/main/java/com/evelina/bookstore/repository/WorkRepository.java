package com.evelina.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evelina.bookstore.entity.Work;

public interface WorkRepository extends JpaRepository<Work,Long>{
    
}
