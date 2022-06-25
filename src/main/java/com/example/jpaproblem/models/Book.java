package com.example.jpaproblem.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long tom;

    private Long pages;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

}
