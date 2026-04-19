package com.evelina.bookstore.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private Long id;
    @NotBlank(message="Имя обязательно")
    private String firstName;
    @NotBlank(message="Фамилия обязательна")
    private String lastName;
}
