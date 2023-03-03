package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class Controller {
    private final ProductRepository productRepository;

    public Controller(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public List<Product> getProducts() {
        System.out.println("getProducts");
        List<Product> response = productRepository.findAllBy();
        return response;
    }
}
