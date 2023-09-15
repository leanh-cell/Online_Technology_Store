package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
