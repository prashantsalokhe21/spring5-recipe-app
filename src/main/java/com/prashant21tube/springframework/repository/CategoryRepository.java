package com.prashant21tube.springframework.repository;

import com.prashant21tube.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String category);
}
