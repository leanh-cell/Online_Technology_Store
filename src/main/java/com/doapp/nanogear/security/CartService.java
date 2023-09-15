package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.Cart;
import com.doapp.nanogear.model.data.Product;
import com.doapp.nanogear.model.data.User;
import com.doapp.nanogear.model.respository.CartRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartService {
//    @Autowired
    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartService(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    public List<Cart> getCartsByUserId(int userId) {
        return cartRepository.getCartsByUserId(userId);
    }
    @Transactional
    public void addToCart(User loggedInUser, int productId) {
        Product product = productService.findById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        // Kiểm tra số lượng tồn kho của sản phẩm
        if (product.getQuantity() <= 0) {
            System.out.println("Out of stock");
        }

        Cart existingCartItem = cartRepository.findByUserAndProduct(loggedInUser, product);
        if (existingCartItem != null) {
            // Nếu sản phẩm đã tồn tại trong giỏ hàng, tăng số lượng lên 1
            existingCartItem.setQuantity(existingCartItem.quantity + 1);
            cartRepository.save(existingCartItem);
        } else {
            Cart cart = new Cart();
            cart.setUser(loggedInUser);
            cart.setQuantity(1); // Số lượng mặc định là 1

            cartRepository.save(cart);
        }
    }

    @Transactional
    public void updateQuantity(int userid,int prdId){
       Cart cart = cartRepository.findByUseridAndProductId(userid,prdId);
       if(cart.quantity < cart.getProduct().getQuantity()){
           cart.setQuantity(cart.quantity + 1);
           cartRepository.save(cart);
       }else if(cart.quantity == cart.getProduct().getQuantity()){
       }

    }
}
