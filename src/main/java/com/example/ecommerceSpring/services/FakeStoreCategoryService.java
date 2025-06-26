package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dto.CategoryDTO;
import com.example.ecommerceSpring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

     public FakeStoreCategoryService(ICategoryGateway _categoryGateway) {
         this.categoryGateway = _categoryGateway;
     }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return this.categoryGateway.getAllCategories();

    }
}
