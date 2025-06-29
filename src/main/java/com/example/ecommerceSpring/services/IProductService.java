package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    ProductDTO getProductById(Long productId) throws Exception;

    List<ProductDTO> getProductsOfCategory(String categoryType) throws Exception;
}
