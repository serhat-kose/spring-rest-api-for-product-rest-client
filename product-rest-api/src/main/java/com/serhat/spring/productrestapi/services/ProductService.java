package com.serhat.spring.productrestapi.services;

import com.serhat.spring.productrestapi.web.model.*;

import java.util.*;

public interface ProductService {
    ProductDto getProductById(UUID productId);

    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(UUID productId,ProductDto productDto);

    void deleteProductById(UUID productId);
}
