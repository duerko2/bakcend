package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Basket;
import com.defaglige.webshop.pojo.Product;

import java.util.NoSuchElementException;

public class BasketService {
    public final BasketRepository basketRepository;
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }
    public Basket getBasket(String basketId) throws NoSuchElementException {
        try {
            return basketRepository.findById(basketId).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Basket does not exist");
        }
    }

    public Basket createBasket(Basket basket) {
        try {
            return basketRepository.save(basket);
        } catch (Exception e) {
            throw new NoSuchElementException("Basket could not be created");
        }
    }
}
