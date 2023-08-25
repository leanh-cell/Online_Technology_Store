package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.Cart;
import com.doapp.nanogear.model.respository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
//    @Autowired
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getUnpaidOrdersByUserId(String userId) {
        return cartRepository.getUnpaidOrdersByUserId(userId);
    }
}
