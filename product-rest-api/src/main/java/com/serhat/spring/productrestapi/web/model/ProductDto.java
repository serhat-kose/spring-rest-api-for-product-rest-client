package com.serhat.spring.productrestapi.web.model;

import com.sun.istack.*;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.*;
import java.util.*;

@Data
@Builder
@Getter
public class ProductDto {

    private Long id;

    private String productName;

    private  String productType;

    private BigDecimal price;

    private Long productCode;

    private Date createdTime;
}
