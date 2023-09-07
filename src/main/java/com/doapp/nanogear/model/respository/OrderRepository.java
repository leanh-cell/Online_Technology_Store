package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetail, Integer> {
    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM OrderDetail o WHERE o.orderCode = :code")
    boolean orderExistsWithCode(@Param("code") String code);



}
