package com.prashant21tube.springframework.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Recipe> recipe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return description;
    }

    public void setCategoryName(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Set<Recipe> recipe) {
        this.recipe = recipe;
    }
}
