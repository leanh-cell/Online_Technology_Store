package com.doapp.nanogear.security;

import com.doapp.nanogear.model.respository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService  {
    public final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean orderExistsWithCode(String code){
        if(orderRepository.orderExistsWithCode(code) == true){
            return true;
        }else{
            return false;
        }
    }
}
