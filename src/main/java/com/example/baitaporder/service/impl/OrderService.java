package com.example.baitaporder.service.impl;

import com.example.baitaporder.model.Order;
import com.example.baitaporder.repository.OrderRepository;
import com.example.baitaporder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public Iterable<Order> findAll() {
        return  orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);

    }

    @Override
    public void remove(Long id) {
        orderRepository.deleteById(id);

    }
}
