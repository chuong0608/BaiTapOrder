package com.example.baitaporder.controller;


import com.example.baitaporder.model.Product;
import com.example.baitaporder.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product> > findAll(){
        Iterable <Product> products= productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Product product, @PathVariable Long id) {
        Optional<Product> postOptional =productService.findById(id);
        if (!postOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(postOptional.get().getId());
        productService.save(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Optional<Product> postOptional = productService.findById(id);
        if (!postOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(postOptional.get(),HttpStatus.OK);
    }

    @GetMapping("/get-product-300")
    public ResponseEntity<Iterable<Product> > getProductByQuantity(){
        Iterable <Product> products= productService.getProductByQuantity();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/get-product-price")
    public ResponseEntity<Iterable<Product>> getProductByPrice(){
        Iterable<Product> products = productService.getProductByPrice();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/find-by-name")
    public  ResponseEntity<Iterable<Product>> findAllByNameContaining(@RequestParam  String name){
        Iterable<Product> products = productService.findAllByNameContaining(name);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }





}
