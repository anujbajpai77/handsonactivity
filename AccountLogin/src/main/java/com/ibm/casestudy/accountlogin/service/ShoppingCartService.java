package com.ibm.casestudy.accountlogin.service;


import java.math.BigDecimal;
import java.util.Map;

import com.ibm.casestudy.accountlogin.exception.NotEnoughProductsInStockException;
import com.ibm.casestudy.accountlogin.model.Product;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();
}

