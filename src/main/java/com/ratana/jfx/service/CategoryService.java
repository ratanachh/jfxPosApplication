package com.ratana.jfx.service;

import com.ratana.jfx.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(long id);
}
