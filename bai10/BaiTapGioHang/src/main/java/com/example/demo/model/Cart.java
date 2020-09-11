package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> listCart;
    private int soluong;
    public Cart(){

        listCart=new HashMap<>();
    }
    public Map<Product,Integer> findAll()
    {
        return listCart;
    }
    public void add(Product product){
        if(listCart.containsKey(product)){
            listCart.replace(product,listCart.get(product),listCart.get(product)+1);
        }else {
            listCart.put(product,1);
        }
    }
    public void sub(Product product){
        if(listCart.containsKey(product)){
            listCart.replace(product,listCart.get(product),listCart.get(product)-1);
        }
       if(listCart.get(product)==0){
            listCart.remove(product);
        }
    }
}
