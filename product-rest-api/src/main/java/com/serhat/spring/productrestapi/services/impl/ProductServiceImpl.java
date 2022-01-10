package com.serhat.spring.productrestapi.services.impl;

import com.serhat.spring.productrestapi.domain.*;
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
public class ProductServiceImpl implements ProductService {


    private final ProductRepository repository;


    private final ProductMapper mapper;

    @Override
    public ProductDto getProductById(Long productId) {

        Product product= repository.findById(productId).get();

        if(product!=null){
            return mapper.productToProductDto(product);
        }
        return null;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {

        Product savedProduct = mapper.productDtoToProduct(productDto);
        repository.save(savedProduct);

        return  mapper.productToProductDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(Long productId,ProductDto productDto) {

        Product product= repository.findById(productId).get();
        if(product!=null){
            productDto.setId(product.getId());
            Product updatedProduct = mapper.productDtoToProduct(productDto);

            return  mapper.productToProductDto(repository.save(updatedProduct));

        }
        return null;
    }
    @Override
    public void deleteProductById(Long productId) {

        Product product = repository.findById(productId).get();

        if(product!=null){
            repository.delete(product);
        }
    }
}
