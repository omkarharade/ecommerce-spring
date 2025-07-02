package com.example.ecommerceSpring.gateway;

import com.example.ecommerceSpring.dto.*;
import com.example.ecommerceSpring.gateway.api.FakeStoreProductApi;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Primary
@Component
public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi _fakeStoreProductApi) {
        this.fakeStoreProductApi = _fakeStoreProductApi;
    }


    @Override
    public ProductDTO getProductById(Long productId) throws Exception {

        // 1. Making the HTTP request to the FakeStore API to fetch the product by ID
        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getProductById(productId).execute().body();
        // 2. Check if the response is null
        if (response == null) {
            throw new IOException("Failed to fetch the product with ID: " + productId + ". The response was null.");
        }
        // 3. Return the product from the response
        return response.getProduct();
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoryType) throws Exception {
        // 1. Making the HTTP request to the FakeStore API to fetch products by category
        FakeStoreProductsOfCategoryResponseDTO response = this.fakeStoreProductApi.getProductsOfCategory(categoryType).execute().body();
        // 2. Check if the response is null
        if (response == null) {
            throw new IOException("Failed to fetch products for category: " + categoryType + ". The response was null.");
        }
        // 3. Return the list of products from the response
        return response.getProducts();
    }
}
