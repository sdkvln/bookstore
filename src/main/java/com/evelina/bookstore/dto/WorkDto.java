package com.evelina.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkDto {
    private Long id;
    @NotBlank(message = "Название обязательно")
    private String title;
    @NotNull
    private Long authorId;
}
