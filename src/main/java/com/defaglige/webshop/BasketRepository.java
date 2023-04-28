package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Basket;
import com.defaglige.webshop.pojo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {
    @Override
    Optional<Basket> findById(String s);
    @Override
    <S extends Basket> S save(S entity);
}
