package com.serhat.spring.productrestapi.web.mappers;

import com.serhat.spring.productrestapi.domain.*;
import com.serhat.spring.productrestapi.web.model.*;
import org.mapstruct.*;

@Mapper
public interface ProductMapper {

    ProductDto productToProductDto(Product product);

    Product productDtoToProduct(ProductDto productDto);
}
