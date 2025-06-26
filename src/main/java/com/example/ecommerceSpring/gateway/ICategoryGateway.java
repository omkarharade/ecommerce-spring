package com.example.ecommerceSpring.gateway;


import com.example.ecommerceSpring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;
}