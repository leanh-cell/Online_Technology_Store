package com.doapp.nanogear.repository;

import java.util.Date;
import java.util.List;

import com.doapp.nanogear.dto.TotalMonth;
import com.doapp.nanogear.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doapp.nanogear.dto.OrderStatistics;
import com.doapp.nanogear.dto.TotalDate;
import com.doapp.nanogear.dto.TotalYear;
import com.doapp.nanogear.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT COUNT(o) FROM Order o")
    long getTotalOrderCount();

    @Query("SELECT COUNT(o) FROM Order o WHERE o.status = 'X' ")
    long getTotalOrderX();
    @Query("SELECT COUNT(o) FROM Order o WHERE o.status = 'N'")
    long getTotalOrderN();
    @Query("SELECT COUNT(o) FROM Order o WHERE o.status = 'H'")
    long getTotalOrderH();

    @Query("select MAX(o.id) +1 from Order o")
    Long selectMaxIdOrder();

    @Query("select MAX(o.id) from Order o")
    Long selectIdOrder();

    @Query("select o from Order o where o.user.id=:userid order by o.id desc")
    List<Order> findByOrderUserId(@Param("userid") String userid);

//    @Query("select o from Order o where o.user.id =: userId or o.status like : key")
//    Page<Order> findByUserIdAndPage(@Param("userId") String userId,@Param("key") String key,Pageable pageable);

    @Query("select o from Order o where o.user.id = :userId and (o.status like :key or :key is null) order by case when o.status = 'X' then 0 else 1 end, o.status asc")
    Page<Order> findByUserIdAndStatusLike(@Param("userId") String userId, @Param("key") String key, Pageable pageable);


    @Query("select o.total from Order o where o.id=:orderid ")
    double findTotalByIdOrder(@Param("orderid") Long id);

    @Query("select o from Order o where o.status = 'X' ")
    List<Order> findByOrderStatusX();

    @Query("select o from Order o where o.status = 'N' ")
    List<Order> findByOrderStatusN();

    @Query("select o from Order o where o.status = 'H' ")
    List<Order> findByOrderStatusH();

    @Query("select o from Order o where o.date between :min and :max and o.status like :status order by o.id desc")
    Page<Order> findByOrderDate(@Param("min") Date minDate, @Param("max") Date maxDate, @Param("status") String status, Pageable pageable);

    @Query("select new TotalYear(YEAR(o.date), sum(o.total)) from Order o where o.status ='N' group by YEAR(o.date) ")
    List<TotalYear> getTotalYear();

    @Query("SELECT NEW TotalMonth(MONTH(o.date), YEAR(o.date), SUM(o.total)) FROM Order o WHERE o.status = 'N' GROUP BY YEAR(o.date), MONTH(o.date) ORDER BY YEAR(o.date), MONTH(o.date)")
    List<TotalMonth> getTotalMonth();

    @Query("select new OrderStatistics(o.status, count(o.status)) from Order o group by o.status ")
    List<OrderStatistics> getStatusOrder();

    @Query("select o from Order o where o.id =:idOrder")
    Page<Order> findByIdKeyWord(@Param("idOrder") Long id, Pageable pageable);

    @Query("SELECT o FROM Order o " +
            "LEFT JOIN o.user u " +
            "WHERE u.name = :keyword OR o.orderCode = :keyword")
    Page<Order> findOrderByOrderCodeAndUserName(@Param("keyword") String keyword,Pageable pageable);

    @Query("select new TotalDate(o.date, sum(o.total)) from Order o where o.date between :date1 and :date2 and o.status = 'N' group by o.date")
    List<TotalDate> findTotalByDate(@Param("date1") Date date1, @Param("date2") Date date2);

    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Order o WHERE o.orderCode = :code")
    boolean orderExistsWithCode(@Param("code") String code);

}
