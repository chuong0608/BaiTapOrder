package com.example.baitaporder.service.impl;

import com.example.baitaporder.model.Product;
import com.example.baitaporder.repository.ProductRepository;
import com.example.baitaporder.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Iterable<Product> findAllByNameContaining(String name) {
        return productRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> getProductByQuantity() {
        return productRepository.getProductByQuantity();
    }

    @Override
    public Iterable<Product> getProductByPrice() {
        return productRepository.getProductByPrice();
    }
}
