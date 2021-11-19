package com.example.jpaproblem.services;

import com.example.jpaproblem.models.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> getAuthorById(Long id);
    Author createAuthor(Author author);
    List<Author> getAllAuthors();
    Author updateUser(Author author);
    void deleteAuthorById(Long id);
}
