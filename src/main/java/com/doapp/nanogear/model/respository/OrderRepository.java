package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Order o WHERE o.orderCode = :code")
    boolean orderExistsWithCode(@Param("code") String code);

    Order findByContactUserId(int id);
}
