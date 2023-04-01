package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllBy();
    Optional<Product> findById(String s);
}
