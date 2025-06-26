package com.example.ecommerceSpring.gateway;

import com.example.ecommerceSpring.dto.CategoryDTO;
import com.example.ecommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.ecommerceSpring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi _fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = _fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        // 1. Making the HTTP request to the FakeStore API to fetch all categories
        FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();
        // 2. Check if the response is null
        if (response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        // 3. Convert the response to a list of CategoryDTO objects
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                        .toList();

    }
}
