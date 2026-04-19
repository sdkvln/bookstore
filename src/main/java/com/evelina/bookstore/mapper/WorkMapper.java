package com.evelina.bookstore.mapper;

import com.evelina.bookstore.dto.WorkDto;
import com.evelina.bookstore.entity.Work;

public class WorkMapper {
    public static WorkDto maptoWorkDto(Work work){
        return new WorkDto(
            work.getId(),
            work.getTitle(),
            work.getAuthor().getId()
        );
    }
}
