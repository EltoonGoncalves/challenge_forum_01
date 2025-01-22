package com.alura.forum.domain.topic;

import com.alura.forum.domain.author.AuthorDTO;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateDTO(
        @NotNull
        Long id,
        String title,
        String message,
        AuthorDTO authorDTO,
        String nameCourse
) {
}
