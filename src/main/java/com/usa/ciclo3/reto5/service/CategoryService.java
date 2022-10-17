package com.usa.ciclo3.reto5.service;

import com.usa.ciclo3.reto5.entity.Category;
import com.usa.ciclo3.reto5.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Transactional(readOnly = true)
    public List<Category> getList() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    
    @Transactional
    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> categoryId = categoryRepository.findById(category.getId());
            
            if (!categoryId.isEmpty()) {
                Category categoryBd = categoryId.get();
                
                categoryBd.setName(category.getName());
                categoryBd.setDescription(category.getDescription());
                categoryBd.setCabins(category.getCabins());
                
                return categoryRepository.save(categoryBd);
                
            } else {
                
                return category;
            }
        }
        return category;
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
