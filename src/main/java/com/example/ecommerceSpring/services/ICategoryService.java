package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;
}
