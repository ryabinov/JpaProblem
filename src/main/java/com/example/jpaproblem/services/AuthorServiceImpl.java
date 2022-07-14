package com.example.jpaproblem.services;

import com.example.jpaproblem.models.Author;
import com.example.jpaproblem.models.dto.AuthorDto;
import com.example.jpaproblem.repository.AuthorRepository;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

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
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> query = builder.createQuery(Author.class);
        Root<Author> root = query.from(Author.class);
        query.select(root);
        List<Author> authorGet = entityManager.createQuery(query).getResultList();

        return authorGet;
    }

//    @Override
//    public Page<Author> getAllMyObjectByFields(int pageIndex, FormMyObject formMyObject) {
//        Specification<Author> spec = new Specification<Author>() {
//            @Override
//            public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
//                if (formMyObject == null) {
//                    throw new IllegalStateException("At least one parameter should be provided to construct complex query");
//                }
//                List<Predicate> predicates = new ArrayList<Predicate>();
//                // only if the content is present add a criteria to the search, you decide/know if will be null, or empty...
//                if (formMyObject.getYourField() != null && formMyObject.getYourField().length() > 0) {
//                    predicates.add(
//                            builder.and(builder.equal(root.get("field"), formMyObject.getYourField())));
//                }
//
//                // add as many criteria as you want/need
//                if () {
//                    predicates.add( ... );
//                }
//
//
//                Predicate[] predicatesArray = new Predicate[predicates.size()];
//                return builder.and(predicates.toArray(predicatesArray));
//            }
//        };
//
//        PageRequest page = new PageRequest(pageIndex, formMyObject.getMaxResult());
//        // using the built in findAll method from Repository with dynamic custom filters
//        return authorRepository.findAll(spec, page);
//    }
}
