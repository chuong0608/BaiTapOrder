package com.example.baitaporder.controller;


import com.example.baitaporder.model.Order;
import com.example.baitaporder.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping
    public ResponseEntity<Iterable<Order>> findAll(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Order order){
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity update(@RequestBody Order order,@RequestParam Long id){
        Optional<Order> orderOptional = orderService.findById(id);
        if (!orderOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        order.setId(orderOptional.get().getId());
        orderService.save(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Optional<Order> orderOptional = orderService.findById(id);
        if(!orderOptional.isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.remove(id);
        return new ResponseEntity<>(orderOptional.get(),HttpStatus.OK);
    }
}
