package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.Cart;
import com.doapp.nanogear.model.data.Product;
import com.doapp.nanogear.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query("SELECT c FROM Cart c WHERE c.user.id = :userid")
    List<Cart> getCartsByUserId(@Param("userid")int userid);


//    void addToCart(User loggedInUser, Long productId);

    Cart findByUserAndProduct(User loggedInUser, Product product);
    @Query("SELECT c FROM Cart c WHERE c.user.id = :userid AND c.product.id = :productId")
    Cart findByUseridAndProductId( @Param("userid") int userid,@Param("productId") int productId);
}
