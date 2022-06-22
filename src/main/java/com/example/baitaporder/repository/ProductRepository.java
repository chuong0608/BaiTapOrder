package com.example.baitaporder.repository;

import com.example.baitaporder.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Iterable<Product> findAllByNameContaining(String name);

    @Query(value = "select * from product where quantity > 300", nativeQuery = true)
    Iterable<Product> getProductByQuantity();

    @Query(value = "select * from  product order by price DESC",nativeQuery = true)
    Iterable<Product> getProductByPrice();
}
