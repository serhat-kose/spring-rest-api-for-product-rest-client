package com.serhat.spring.productrestapi.web.model;

import java.math.*;
import java.sql.*;
import java.time.*;

public class BaseTest {

    ProductDto getDto(){
        return ProductDto.builder()
                .productName("Television")
                .productType("TECH")
                .productCode(12321355L)
                .id(1323535L)
                .price(new BigDecimal("150"))
                .createdTime(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
}
