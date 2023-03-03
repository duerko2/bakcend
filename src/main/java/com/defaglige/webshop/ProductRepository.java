package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllBy();
}
