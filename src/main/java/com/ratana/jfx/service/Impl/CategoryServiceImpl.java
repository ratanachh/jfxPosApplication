package com.ratana.jfx.service.Impl;

import com.ratana.jfx.model.Category;
import com.ratana.jfx.repository.CategoryRepository;
import com.ratana.jfx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(long id) {
        return repository.findById(id).get();
    }
}
