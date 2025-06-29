package com.example.ecommerceSpring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductsOfCategoryResponseDTO {
	private String message;
	private String status;
	private List<ProductDTO> products;
}