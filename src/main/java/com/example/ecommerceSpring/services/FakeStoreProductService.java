package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dto.ProductDTO;
import com.example.ecommerceSpring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway _productGateway) {
        this.productGateway = _productGateway;
    }

    @Override
    public ProductDTO getProductById(Long productId) throws Exception {
        return productGateway.getProductById(productId);
    }

    @Override
    public List<ProductDTO> getProductsOfCategory(String categoryType) throws Exception {
        return productGateway.getProductsByCategory(categoryType);
    }


}
