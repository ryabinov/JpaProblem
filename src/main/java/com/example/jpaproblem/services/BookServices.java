package com.example.jpaproblem.services;

import com.example.jpaproblem.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookServices {

    Optional<Book> getBookById(Long id);
    Book createBook(Book book);

    List<Book> getAllBooks();
    Book updateBook(Book book);

    void deleteBookById(Long id);
}
