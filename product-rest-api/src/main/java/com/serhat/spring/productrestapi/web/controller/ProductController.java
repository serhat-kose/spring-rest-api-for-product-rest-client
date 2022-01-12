package com.serhat.spring.productrestapi.web.controller;

import com.serhat.spring.productrestapi.payload.*;
import com.serhat.spring.productrestapi.services.*;
import com.serhat.spring.productrestapi.web.model.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponsePayload getProductById(@PathVariable("productId")Long productId){

        return productService.getProductById(productId);
    }

    @PostMapping
    public ResponsePayload saveProduct(@RequestBody @Valid ProductDto productDto){
        return productService.saveProduct(productDto);

    }

    @PutMapping("/{productId}")
    public ResponsePayload updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
            ;
        return productService.updateProduct(productId,productDto);
    }

    @DeleteMapping("/{productId}")
    public ResponsePayload deleteProductById(@PathVariable("productId") Long productId){

        return productService.deleteProductById(productId);

    }
}
