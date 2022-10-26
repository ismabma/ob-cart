package com.obcart.obcart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obcart.obcart.entities.Cart;
import com.obcart.obcart.entities.Product;

@RestController
public class CartController {
    private Cart cart;

    @GetMapping("/cart")
    public Cart getCart(){
        return cart;
    }

    @DeleteMapping("/cart")
    public ResponseEntity<String> deleteCart(){
        this.cart = new Cart();
        return new ResponseEntity<String>("Cart Deleted", HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<String> createCart(){
        this.cart = new Cart();
        return new ResponseEntity<String>("Cart Created", HttpStatus.OK);
    }

    @DeleteMapping("/cart/products")
    public ResponseEntity<String> removeProduct(@RequestBody int id, @RequestBody String description, @RequestBody int amount){
        Product p = new Product(id, description, amount);
        return new ResponseEntity<String>(this.cart.addProducts(p), HttpStatus.OK);
    }

    @PostMapping("/cart/products")
    public ResponseEntity<String> addProduct(@RequestBody int id, @RequestBody String description, @RequestBody int amount){
        Product p = new Product(id, description, amount);
        return new ResponseEntity<String>(this.cart.addProducts(p), HttpStatus.OK);
    }
}
