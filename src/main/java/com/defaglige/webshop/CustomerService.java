package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Customer;

import java.util.NoSuchElementException;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }




    public void createCustomer(Customer customer){
            customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer, String id) throws  NoSuchElementException{
        try {
            customerRepository.findByCustomerId(id).orElseThrow();
            customerRepository.save(customer);

        }catch (NoSuchElementException e){
            throw new NoSuchElementException("No such customer");
        }






    }
    public Customer getCustomer (String id) throws  NoSuchElementException{
        try{
           return customerRepository.findByCustomerId(id).orElseThrow();

        }catch (NoSuchElementException e){
            throw new NoSuchElementException("No such customer");
        }
    }

}
