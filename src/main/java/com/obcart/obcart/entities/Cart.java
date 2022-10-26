package com.obcart.obcart.entities;

import java.util.HashMap;


public class Cart {
    private HashMap<Integer,Product> products = new HashMap<Integer,Product>();

    public String addProducts(int id, int quantity){
        if(products.containsKey(id)){
            Product tmp = products.get(id);
            tmp.addToCart(quantity);
            products.put(tmp.getId(), tmp);
        } else {
            return "Product does not exist";
        }
        return "Product/s have been added";
    }

    public String removeProducts(int id, int quantity){
        if(products.containsKey(id)){
            Product tmp = products.get(id);
            tmp.removeFromCart(quantity);
            products.put(tmp.getId(), tmp);
        } else {
            return "Product is not in the cart";
        }
        return "Products deleted";
    }
    
    public String addProduct(Product p){
        if(products.containsKey(p.getId())){
            products.put(p.getId(), p);
        }
        return "Product/s have been added";
    }

    public String removeProduct(Product p){
        if(products.containsKey(p.getId())){
            products.put(p.getId(), p);
        } else {
            return "Product is not in the cart";
        }
        return "Products deleted";
    }

    public Product getProductById(int id){
        if(products.containsKey(id)){
            return products.get(id);
        } else {
            return null;
        }
    }
}
