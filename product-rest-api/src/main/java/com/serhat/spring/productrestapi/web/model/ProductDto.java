package com.serhat.spring.productrestapi.web.model;

import com.sun.istack.*;
import lombok.*;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import java.math.*;
import java.util.*;

@Data
@Builder
@Getter
public class ProductDto {

    private Long id;

    @NotNull
    private String productName;

    @NotNull
    private  String productType;

    @Positive
    private BigDecimal price;

    @Positive
    private Long productCode;

    private Date createdTime;
}
