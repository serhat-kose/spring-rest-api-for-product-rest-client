package com.serhat.spring.productrestapi.services;

import com.serhat.spring.productrestapi.payload.*;
import com.serhat.spring.productrestapi.web.model.*;

import java.util.*;

public interface ProductService {
    ResponsePayload getProductById(Long productId);

    ResponsePayload saveProduct(ProductDto productDto);

    ResponsePayload updateProduct(Long productId,ProductDto productDto);

    ResponsePayload deleteProductById(Long productId);
}
