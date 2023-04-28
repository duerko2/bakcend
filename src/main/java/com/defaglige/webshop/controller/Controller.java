package com.defaglige.webshop.controller;

import com.defaglige.webshop.ProductRepository;
import com.defaglige.webshop.ProductService;
import com.defaglige.webshop.pojo.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin
@RestController
@RequestMapping("/products")
@ResponseBody
@ResponseStatus(HttpStatus.OK)
public class Controller {
    private final ProductService productService;

    public Controller(ProductRepository productRepository) {
        this.productService = new ProductService(productRepository);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        System.out.println("getProducts");

        try {
            List<Product> products = productService.getAllProducts();
            //ResponseEntity<List<Product>> response = new ResponseEntity<>(products,HttpStatus.OK);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Database Connection Error");
        }
    }
    @PutMapping("/{productId}")
    public ResponseEntity<String> putProduct(@PathVariable String productId, @RequestBody Product product)  {
        System.out.println("putProduct");
        try{
            productService.updateProduct(product,productId);
            return ResponseEntity.ok("Product updated");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(),e);
        }
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        System.out.println("getProduct");
        try {
            Product product = productService.getProduct(productId);
            return ResponseEntity.ok(product);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(),e);
        }
    }
}
