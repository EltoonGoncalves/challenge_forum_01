package com.alura.forum.domain.author;

public record AuthorResponseDTO(
        String name,
        String email
) {
    public AuthorResponseDTO(Author author){
        this(author.getName(), author.getEmail());
    }
}
