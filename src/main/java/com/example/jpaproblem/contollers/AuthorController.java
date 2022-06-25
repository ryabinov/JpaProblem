package com.example.jpaproblem.contollers;

import com.example.jpaproblem.models.Author;
import com.example.jpaproblem.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
        @ResponseBody
        @GetMapping("/getAuthorById/{id}")
        public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long id) {
            return ResponseEntity.ok(authorService.getAuthorById(id));
        }
        @ResponseBody
        @PostMapping("/create")
        public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
            return ResponseEntity.ok(authorService.createAuthor(author));
        }
        @ResponseBody
        @GetMapping("/getAllAuthors")
        public ResponseEntity<Iterable<Author>> getAllAuthors() {
            return ResponseEntity.ok().body(authorService.getAllAuthors());
        }
        @ResponseBody
        @PutMapping("/update")
        public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
            return ResponseEntity.ok(authorService.updateUser(author));
        }
        @ResponseBody
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deleteAuthor(@PathVariable("id") Long id) {
            authorService.deleteAuthorById(id);
            return ResponseEntity.ok().build();
        }

    @ResponseBody
    @GetMapping("/getAllFields")
    public ResponseEntity<Iterable<Author>> getAllFields() {
        return ResponseEntity.ok().body(authorService.getAllFields());
    }
    }

