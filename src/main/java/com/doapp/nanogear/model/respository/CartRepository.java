package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> getUnpaidOrdersByUserId(String userid);
}
