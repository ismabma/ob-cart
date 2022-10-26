package com.obcart.obcart.entities;

import java.util.HashMap;


public class Cart {
    private HashMap<Integer,Product> products;

    public String addProducts(Product p){
        if(products.containsKey(p.getId())){
            products.put(p.getId(), p);
        }
        return "Product/s have been added";
    }

    public String removeProducts(Product p){
        if(products.containsKey(p.getId())){
            products.put(p.getId(), p);
        } else {
            return "Product is not in the cart";
        }
        return "Products deleted";
    }
}
