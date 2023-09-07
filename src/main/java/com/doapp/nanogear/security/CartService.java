package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.Cart;
import com.doapp.nanogear.model.data.Product;
import com.doapp.nanogear.model.data.User;
import com.doapp.nanogear.model.respository.CartRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    public void addToCart(User loggedInUser, int productId) {
        Product product = productService.findById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }

        // Kiểm tra số lượng tồn kho của sản phẩm
        if (product.getQuantity() <= 0) {
            System.out.println("Out of stock");
        }

        // Kiểm tra xem sản phẩm có thuộc về chính người dùng đang đăng nhập không
//        if (product.getSeller().getUserId().equals(loggedInUser.getUserId())) {
//            System.out.println("You cannot add your own product to the cart");
//        }

        Cart existingCartItem = cartRepository.findByUserAndProduct(loggedInUser, product);
        if (existingCartItem != null) {
            // Nếu sản phẩm đã tồn tại trong giỏ hàng, tăng số lượng lên 1
            existingCartItem.setQuantity(existingCartItem.quantity + 1);
            cartRepository.save(existingCartItem);
        } else {
            Cart cart = new Cart();
            cart.setUser(loggedInUser);
            cart.setQuantity(1); // Số lượng mặc định là 1

            // Tạo danh sách sản phẩm nếu chưa tồn tại
            if (cart.getProduct() == null) {
                cart.setProduct(new ArrayList<>());
            }

            // Thêm sản phẩm vào danh sách
            cart.getProduct().add(product);

            cartRepository.save(cart);

//            // Nếu sản phẩm chưa tồn tại trong giỏ hàng, tạo mới CartItem
//            Cart cart = new Cart();
//            cart.setUser(loggedInUser);
//            cart.setProduct(product);
//            cart.setQuantity(1); // Số lượng mặc định là 1
//            cartRepository.save(cart);
        }
    }
}
