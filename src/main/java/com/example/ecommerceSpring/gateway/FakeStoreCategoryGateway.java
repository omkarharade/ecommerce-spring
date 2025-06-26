package com.example.ecommerceSpring.gateway;

import com.example.ecommerceSpring.dto.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{
    @Override
    public List<CategoryDTO> getAllCategories() {
        return null;
    }
}
