package com.example.ecommerceSpring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductResponseDTO{
	private ProductDTO product;
	private String message;
	private String status;
}
