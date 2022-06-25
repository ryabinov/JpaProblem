package com.example.jpaproblem.services;

import com.example.jpaproblem.models.Author;
import com.example.jpaproblem.repository.AuthorRepository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @PersistenceContext
    EntityManager entityManager;

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {

        return authorRepository.findById(id);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateUser(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> getAllFields() {
        JPAQuery query = new JPAQuery(entityManager);
        QProject project = QProject.project;
        List<Tuple> result = query.from(projects).list(project.projectId, project.projectName);
        for (Tuple row : result) {
            System.out.println("project ID " + row.get(project.projectId));
            System.out.println("project Name " + row.get(project.projectName));
        }
        return null;
    }
}
