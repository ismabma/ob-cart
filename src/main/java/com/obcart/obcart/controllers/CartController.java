package com.obcart.obcart.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.obcart.obcart.entities.Cart;
import com.obcart.obcart.entities.Product;

@RestController
public class CartController {
    private Cart cart = new Cart();

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

    @DeleteMapping("/cart/product")
    public ResponseEntity<String> removeProduct(@RequestBody int id, @RequestBody String description, @RequestBody int amount){
        Product p = new Product(id, description, amount);
        return new ResponseEntity<String>(this.cart.removeProduct(p), HttpStatus.OK);
    }

    @PostMapping("/cart/product")
    public ResponseEntity<String> addProduct(@RequestBody int id, @RequestBody String description, @RequestBody int amount){
        Product p = new Product(id, description, amount);
        return new ResponseEntity<String>(this.cart.addProduct(p), HttpStatus.OK);
    }

    @DeleteMapping("/cart/products")
    public ResponseEntity<String> removeProducts(@RequestBody int id, @RequestBody int amount){
        return new ResponseEntity<String>(this.cart.removeProducts(id, amount), HttpStatus.OK);
    }

    @PostMapping("/cart/products")
    public ResponseEntity<String> addProducts(@RequestBody int id, @RequestBody int amount){
        return new ResponseEntity<String>(this.cart.addProducts(id, amount), HttpStatus.OK);
    }

    @GetMapping("/cart/products/{id}")
    public ResponseEntity<Product> addProducts(@PathVariable int id){
        Product p = this.cart.getProductById(id);
        if(p==null) p = new Product(0, "Product does not exist", 0);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }
}
