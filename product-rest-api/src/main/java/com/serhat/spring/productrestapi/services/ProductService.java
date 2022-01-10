package com.serhat.spring.productrestapi.services;

import com.serhat.spring.productrestapi.web.model.*;

import java.util.*;

public interface ProductService {
    ProductDto getProductById(Long productId);

    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(Long productId,ProductDto productDto);

    void deleteProductById(Long productId);
}
