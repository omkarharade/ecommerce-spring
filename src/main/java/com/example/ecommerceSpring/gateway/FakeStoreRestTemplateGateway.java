package com.example.ecommerceSpring.gateway;

import com.example.ecommerceSpring.dto.CategoryDTO;
import com.example.ecommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.example.ecommerceSpring.mappers.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder _restTemplateBuilder) {
        this.restTemplateBuilder = _restTemplateBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        RestTemplate restTemplate = this.restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category";


        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);

        if(!response.hasBody()){
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        return GetAllCategoriesMapper.toCategoryDto(response.getBody());


    }
}
