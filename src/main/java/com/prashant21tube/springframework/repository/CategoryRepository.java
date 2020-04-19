package com.prashant21tube.springframework.repository;

import com.prashant21tube.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
