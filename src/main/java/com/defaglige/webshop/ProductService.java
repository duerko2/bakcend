package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Product;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAllBy();
    }

    public void updateProduct(Product product, String productId) throws NoSuchElementException{
        // Tjekker om produktet findes allerede. Vi vil ikke tillade brugere at
        // tilføje/ændre nye produkter udefra, så kaster exception hvis produktet ikke findes.
        // Flere checks
        try {
            productRepository.findById(productId).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Product does not exist");
        }
        if(!product.get_id().equals(productId))
            throw new NoSuchElementException("Product id does not match path id");
        productRepository.save(product);
    }

    public Product getProduct(String productId) throws NoSuchElementException{
        try {
            return productRepository.findById(productId).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Product does not exist");
        }
    }
}
