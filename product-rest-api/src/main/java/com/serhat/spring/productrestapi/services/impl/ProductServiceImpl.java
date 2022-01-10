package com.serhat.spring.productrestapi.services.impl;

import com.serhat.spring.productrestapi.services.*;
import com.serhat.spring.productrestapi.web.model.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDto getProductById(UUID productId) {
        return null;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        return ProductDto.builder()
                .productName("Laptop")
                .productType("Technology")
                .productCode(234234L)
                .price(new BigDecimal("250"))
                .build();
    }

    @Override
    public ProductDto updateProduct(UUID productId,ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProductById(UUID productId) {

    }
}
