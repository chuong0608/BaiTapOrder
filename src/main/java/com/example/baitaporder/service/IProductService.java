package com.example.baitaporder.service;

import com.example.baitaporder.model.Product;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findAllByNameContaining(String name);

    Iterable<Product> getProductByQuantity();

    Iterable<Product> getProductByPrice();
}
