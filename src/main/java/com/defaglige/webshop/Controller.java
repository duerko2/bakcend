package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Customer;
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
    private final CustomerService customerService;

    public Controller(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productService = new ProductService(productRepository);
        this.customerService = new CustomerService(customerRepository);
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
    public ResponseEntity<String> putProduct(@PathVariable String productId, @RequestBody Product product) {
        System.out.println("putProduct");
        try {
            productService.updateProduct(product, productId);
            return ResponseEntity.ok("Product updated");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        System.out.println("getProduct");
        try {
            Product product = productService.getProduct(productId);
            return ResponseEntity.ok(product);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/{productId}/stock")
    public ResponseEntity<Integer> getProductStock(@PathVariable String productId) {
        System.out.println("getStock");
        try {
            int stock = productService.getProductStock(productId);
            return ResponseEntity.ok(stock);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/{productId}/stock")
    public ResponseEntity<String> putStock(@PathVariable String productId, @RequestBody int stock) {
        System.out.println("updating stock");
        try {
            productService.putStock(productId, stock);
            return ResponseEntity.ok("stock updated");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/{productId}/stock")
    public ResponseEntity<String> setStock(@PathVariable String productId, @RequestBody int stock) {
        System.out.println("setting stock");
        try {
            productService.setStock(productId, stock);
            return ResponseEntity.ok("stock set");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PutMapping("/{customer}")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        System.out.println("Creating customer");
        try {
            customerService.createCustomer(customer);
            return ResponseEntity.ok(customer);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/{customer")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer, String code) {
        if (code == customerService.getCustomer(customerId).getPassword())
            System.out.println("Updating customer");
        try {
            customerService.updateCustomer(customer, customerId);
            return ResponseEntity.ok(customer);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("customer")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId, String password) {
        if (password == customerService.getCustomer(customerId).getPassword()) {
            System.out.println("Get customer");
            try {
                Customer customer = customerService.getCustomer(customerId);
                return ResponseEntity.ok(customer);
            } catch (NoSuchElementException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
            }
        }
        return null;


    }
}