package com.example.ecommerceSpring.controllers;

import com.example.ecommerceSpring.dto.CategoryDTO;
import com.example.ecommerceSpring.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;
    public CategoryController(ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return this.categoryService.getAllCategories();
    }


}
