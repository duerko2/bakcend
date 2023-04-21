package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository {

    Optional<Customer> findByCustomerId(String id);
}
