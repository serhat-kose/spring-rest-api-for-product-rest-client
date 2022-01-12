package com.serhat.spring.productrestapi.services.impl;

import com.serhat.spring.productrestapi.domain.*;
import com.serhat.spring.productrestapi.payload.*;
import com.serhat.spring.productrestapi.repository.*;
import com.serhat.spring.productrestapi.services.*;
import com.serhat.spring.productrestapi.web.mappers.*;
import com.serhat.spring.productrestapi.web.model.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends AbstractResponsePayload implements ProductService {


    private final ProductRepository repository;


    private final ProductMapper mapper;

    @Override
    public ResponsePayload getProductById(Long productId) {

        Product product= repository.findById(productId).get();

        if(product!=null){
            return getResponse(mapper.productToProductDto(product));
        }
        return null;
    }

    @Override
    public ResponsePayload saveProduct(ProductDto productDto) {

        Product savedProduct = mapper.productDtoToProduct(productDto);
        repository.save(savedProduct);

        return  getResponse(mapper.productToProductDto(savedProduct));
    }

    @Override
    public ResponsePayload updateProduct(Long productId,ProductDto productDto) {

        Product product= repository.findById(productId).get();
        if(product!=null){
            productDto.setId(product.getId());
            Product updatedProduct = mapper.productDtoToProduct(productDto);

            return  getResponse(mapper.productToProductDto(repository.save(updatedProduct)));

        }
        return null;
    }
    @Override
    public ResponsePayload deleteProductById(Long productId) {

        Product product = repository.findById(productId).get();

        if(product!=null){
            repository.delete(product);

            return getResponse(true);
        }

        return getResponse(false);
    }
}
