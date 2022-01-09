package com.serhat.spring.productrestapi.web.controller;

import com.serhat.spring.productrestapi.services.*;
import com.serhat.spring.productrestapi.web.model.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId")UUID productId){

        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }
}
