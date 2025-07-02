package com.example.ecommerceSpring.gateway;

import com.example.ecommerceSpring.dto.CategoryDTO;
import com.example.ecommerceSpring.dto.FakeStoreCategoryResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryGatewayOkhttp")
public class FakeStoreCategoryGatewayOkhttp implements ICategoryGateway {

    // This class is intended to implement the ICategoryGateway interface
    // using OkHttp for making HTTP requests to the FakeStore API.

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        // Implementation will go here

        List<CategoryDTO> allCategories = List.of();

        Request request = new Request.Builder()
                .url("https://fakestoreapi.in/api/products/category")
                .build();


        try(Response response = client.newCall(request).execute()){

            if(!response.isSuccessful()){
                throw new IOException("Error while getting all categories by OKHTTP client" + response);
            }

            if(response.body() == null){
                throw new IOException("Response body is null while getting all categories by OKHTTP client");
            }

            String responseBody = response.body().string();

            allCategories = objectMapper.readValue(responseBody, FakeStoreCategoryResponseDTO.class)
                    .getCategories()
                    .stream()
                    .map(category -> CategoryDTO.builder()
                            .name(category)
                            .build())
                    .toList();

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return allCategories;
    }
}
