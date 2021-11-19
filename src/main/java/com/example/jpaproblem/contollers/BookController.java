package com.example.jpaproblem.contollers;

import com.example.jpaproblem.models.Author;
import com.example.jpaproblem.models.Book;
import com.example.jpaproblem.services.BookServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }
    @ResponseBody
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookServices.getBookById(id));
    }
    @ResponseBody
    @PostMapping("/create")
    public ResponseEntity<Book> createUser(@RequestBody Book book) {
        return ResponseEntity.ok(bookServices.createBook(book));
    }
    @ResponseBody
    @GetMapping("/getAllBooks")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return ResponseEntity.ok().body(bookServices.getAllBooks());
    }
    @ResponseBody
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookServices.updateBook(book));
    }
    @ResponseBody
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        bookServices.deleteBookById(id);
        return ResponseEntity.ok().build();
    }
}
