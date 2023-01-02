package com.service;

import com.domain.Category;
//import com.repository.LeaveApplicationImplRepository;
import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService  {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category insert(Category category) {
        return categoryRepository.create(category);
    }

    @Transactional(readOnly = true)
    public Category get(Long id) {
        return categoryRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Transactional
    public Category update(Category category) {
        return categoryRepository.update(category);
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
    @Transactional(readOnly = true)
    public Category getByCategoryName(String categoryname) {
        return categoryRepository.getByCategoryname(categoryname);
    }
}
