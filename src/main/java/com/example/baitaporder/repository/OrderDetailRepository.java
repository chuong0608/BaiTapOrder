package com.example.baitaporder.repository;

import com.example.baitaporder.model.OrderDetail;
import com.example.baitaporder.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
