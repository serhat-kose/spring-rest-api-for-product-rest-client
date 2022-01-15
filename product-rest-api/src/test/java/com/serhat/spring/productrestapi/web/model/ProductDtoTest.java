package com.serhat.spring.productrestapi.web.model;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class ProductDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializedDto() throws JsonProcessingException {
        ProductDto productDto = getDto();
        String jsonString = objectMapper.writeValueAsString(productDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeSerialize() throws JsonProcessingException {
        String json = "{\"id\":1323535,\"productName\":\"Television\",\"productType\":\"TECH\",\"price\":150,\"productCode\":12321355,\"createdTime\":\"2022-01-15T11:57:47.870+00:00\"}";
        ProductDto dto = objectMapper.readValue(json,ProductDto.class);
        System.out.println(dto);
    }
}
