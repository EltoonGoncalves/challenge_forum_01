package com.alura.forum.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicDTO(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long idAuthor,
        @NotBlank
        String nameCourse){
}