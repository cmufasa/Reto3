package com.usa.ciclo3.reto4.service;

import com.usa.ciclo3.reto4.entity.Category;
import com.usa.ciclo3.reto4.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getList() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    
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

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

}
