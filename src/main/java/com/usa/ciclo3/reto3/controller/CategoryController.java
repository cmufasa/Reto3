package com.usa.ciclo3.reto3.controller;

import com.usa.ciclo3.reto3.entity.Category;
import com.usa.ciclo3.reto3.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/Category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getCategoryList(){
        return categoryService.getList();
    }
    
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return categoryService.getById(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertCategory(@RequestBody Category category){
       categoryService.save(category);
       return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable("id") Long id){
       categoryService.delete(id);
       return ResponseEntity.status(204).build();
    }
    
}
