package com.evelina.bookstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;
    @NotBlank(message="isbn обязателен")
    private String isbn;
    private String title;
    @NotBlank(message="издатель обязателен")
    private String publisher;
    @Min(value = 0, message="Год не может быть отрицательным")
    private int year;
    @Positive(message="Ценп должна быть полоджительная")
    private double price;
    private String status;
    @NotNull
    private Long workId;
}
