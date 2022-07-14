package com.example.specification.repository;

import com.example.specification.model.Category;
import com.example.specification.model.Product;
import com.example.specification.model.STATE;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByNameLike(String name);

    List<Product> findAllByNameLikeAndPriceLessThanEqual(String name, Double price);

    List<Product> findAllByCategoryInAndPriceLessThanEqual(List<Category> categories, Double price);

    List<Product> findAllByCategoryInAndPriceBetween(List<Category> categories,
                                                       Double bottom, Double top);

    List<Product> findAllByNameLikeAndCategoryIn(String name, List<Category> categories);

    List<Product> findAllByNameLikeAndCategoryInAndPriceBetween(String name, List<Category> categories,
                                                                  Double bottom, Double top);

    List<Product> findAllByNameLikeAndCategoryInAndPriceBetweenAndManufacturingPlace_State(String name,
                                                                                             List<Category> categories,
                                                                                             Double bottom, Double top,
                                                                                             STATE state);

}
