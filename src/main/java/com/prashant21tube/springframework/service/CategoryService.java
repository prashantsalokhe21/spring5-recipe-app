package com.prashant21tube.springframework.service;

import com.prashant21tube.springframework.domain.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService extends CrudService<Category, Long> {
}
