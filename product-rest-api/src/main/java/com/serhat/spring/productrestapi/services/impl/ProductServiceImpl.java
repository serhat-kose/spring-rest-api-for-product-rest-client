package com.serhat.spring.productrestapi.services.impl;

import com.serhat.spring.productrestapi.domain.*;
import com.serhat.spring.productrestapi.enumeration.*;
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

        Optional<Product> product= repository.findById(productId);

        if(product.isPresent()){
            return getResponse(mapper.productToProductDto(product.get()));
        }
        return getResponse(ResponseEnum.ERROR, "There is no value present");
    }

    @Override
    public ResponsePayload saveProduct(ProductDto productDto) {

        Product savedProduct = mapper.productDtoToProduct(productDto);
        repository.save(savedProduct);

        return  getResponse(mapper.productToProductDto(savedProduct));
    }

    @Override
    public ResponsePayload updateProduct(Long productId,ProductDto productDto) {

        Optional<Product> product= repository.findById(productId);
        if(product.isPresent()){
            productDto.setId(product.get().getId());
            Product updatedProduct = mapper.productDtoToProduct(productDto);

            return  getResponse(mapper.productToProductDto(repository.save(updatedProduct)));

        }
        return getResponse(ResponseEnum.ERROR, "There is an Error updating the data");
    }
    @Override
    public ResponsePayload deleteProductById(Long productId) {

        Optional<Product> product = repository.findById(productId);

        if(product.isPresent()){
            repository.delete(product.get());

            return getResponse(true);
        }

        return getResponse(ResponseEnum.ERROR, "Data cannot be deleted");
    }
}
