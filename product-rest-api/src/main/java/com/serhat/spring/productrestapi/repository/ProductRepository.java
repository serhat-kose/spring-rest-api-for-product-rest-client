package com.serhat.spring.productrestapi.repository;

import com.serhat.spring.productrestapi.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
