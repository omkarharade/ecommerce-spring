package com.example.ecommerceSpring.gateway.api;

import com.example.ecommerceSpring.dto.FakeStoreCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

public interface FakeStoreCategoryApi {

    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories() throws IOException;
}
