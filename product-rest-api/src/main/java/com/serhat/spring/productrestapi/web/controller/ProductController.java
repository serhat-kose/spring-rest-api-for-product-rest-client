package com.serhat.spring.productrestapi.web.controller;

import com.serhat.spring.productrestapi.services.*;
import com.serhat.spring.productrestapi.web.model.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId")Long productId){

        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@Validated @RequestBody ProductDto productDto){
        return  new ResponseEntity<>(productService.saveProduct(productDto),HttpStatus.CREATED);

    }

    @PutMapping("/{productId}")
    public ResponseEntity updateProduct(@PathVariable("productId") Long productId,@RequestBody ProductDto productDto){
            productService.updateProduct(productId,productDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity deleteProductById(@PathVariable("productId") Long productId){
        productService.deleteProductById(productId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
