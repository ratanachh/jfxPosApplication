package com.ratana.jfx.service.Impl;

import com.ratana.jfx.model.Category;
import com.ratana.jfx.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(int id) {
        return null;
    }
}
