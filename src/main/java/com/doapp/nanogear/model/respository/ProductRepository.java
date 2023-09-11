package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //     List<Product> SearchProductByNameOrPrice(String name,int price);
    @Query("SELECT p FROM Product p " +
            "WHERE (:keyword IS NULL OR " +
            "       p.name LIKE %:keyword% OR " +
            "       EXISTS (SELECT c FROM p.category c WHERE c.name LIKE %:keyword%)) " +
            "AND (p.price >= :price - 100 AND p.price <= :price + 100) " +
            "ORDER BY " +
            "       CASE WHEN p.name LIKE %:keyword% THEN 1 " +
            "            ELSE 2 " +
            "       END, " +
            "       p.price")
    List<Product> searchProducts(@Param("keyword") String keyword,
                                 @Param("price") Double price);

    List<Product> findAll();

}
