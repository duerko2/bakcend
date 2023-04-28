package com.defaglige.webshop;

import com.defaglige.webshop.pojo.Basket;
import com.defaglige.webshop.pojo.NewBasketDTO;
import com.defaglige.webshop.pojo.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;
@CrossOrigin
@RestController
@ResponseBody
@ResponseStatus(HttpStatus.OK)
@RequestMapping("/basket")
public class BasketController {
    public BasketService basketService;
    public BasketController(BasketRepository basketRepository) {
        this.basketService = new BasketService(basketRepository);
    }

    @PostMapping("/new")
    public ResponseEntity<Basket> createBasket(@RequestBody Basket basket) {
        System.out.println("new Basket: "+basket);
        try {
            Basket returnBasket = basketService.createBasket(basket);
            return ResponseEntity.ok(returnBasket);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(),e);
        }
    }
    @GetMapping("/{basketId}")
    public ResponseEntity<Basket> getBasketById(@PathVariable String basketId) {
        System.out.println("getBasketById: "+basketId);
        try {
            Basket basket = basketService.getBasket(basketId);
            return ResponseEntity.ok(basket);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(),e);
        }
    }
}
