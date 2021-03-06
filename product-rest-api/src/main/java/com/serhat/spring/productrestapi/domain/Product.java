package com.serhat.spring.productrestapi.domain;

import com.sun.istack.*;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.*;
import java.math.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
