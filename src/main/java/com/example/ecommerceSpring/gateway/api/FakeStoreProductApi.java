package com.example.ecommerceSpring.gateway.api;

import com.example.ecommerceSpring.dto.FakeStoreProductResponseDTO;
import com.example.ecommerceSpring.dto.FakeStoreProductsOfCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.io.IOException;

public interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getProductById(@Path("id") Long id) throws IOException;

    @GET("products/category")
    Call<FakeStoreProductsOfCategoryResponseDTO> getProductsOfCategory(@Query("type") String categoryType) throws IOException;

}
