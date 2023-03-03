package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;
/*
@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
@Configuration
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return strings -> {
            productRepository.saveAll(List.of(
                    new Product("1", "Bread", "1", 10,"DKK", 4, 2, "3"),
                    new Product("2", "Milk", "2", 20,"DKK", 2, 10, "1"),
                    new Product("3", "Eggs", "3", 30,"DKK", 1, 25, "2")
            ));
        };
    }

}

 */