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
}
