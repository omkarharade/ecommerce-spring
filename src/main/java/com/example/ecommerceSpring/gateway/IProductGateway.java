package com.example.ecommerceSpring.gateway;

import com.example.ecommerceSpring.dto.ProductDTO;

import java.util.List;

public interface IProductGateway {

    ProductDTO getProductById(Long productId) throws Exception;

    List<ProductDTO> getProductsByCategory(String categoryType) throws Exception;
}
