package com.example.ecommerceSpring.controllers;
import com.example.ecommerceSpring.dto.ProductDTO;
import com.example.ecommerceSpring.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService _productService) {
        this.productService = _productService;
    }

    @GetMapping("{id}")
    public ProductDTO getProductById(@PathVariable("id") Long productId) throws Exception {
        return this.productService.getProductById(productId);
    }

    @GetMapping("/category")
    public List<ProductDTO> getProductsOfCategory(@RequestParam(name = "type") String categoryType) throws Exception {
        return this.productService.getProductsOfCategory(categoryType);

    }

}
