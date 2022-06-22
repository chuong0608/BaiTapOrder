package com.example.baitaporder.repository;

import com.example.baitaporder.model.Order;
import com.example.baitaporder.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {


}
