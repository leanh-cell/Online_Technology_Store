package com.doapp.nanogear.repository;
import java.util.List;

//import org.hibernate.transform.ResultTransformer;
import com.doapp.nanogear.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doapp.nanogear.dto.OrderDetailDTO;
import com.doapp.nanogear.entity.OrderDetail;
import com.doapp.nanogear.dto.RevenueByCategory;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

//	@Query("select o from OrderDetail o where o.order.id=:idorder ")
//	List<OrderDetail> findByOrderDetailIdOrder(@Param("idorder") long idOrder);	
	
	@Query("select new OrderDetailDTO(o.id,o.product.name, o.product.img, o.product.price, o.quantity, o.total, o.order.province,  o.order.district,  o.order.addressDetail , o.product.id  ) from OrderDetail o where o.order.id=:idorder")
	List<OrderDetailDTO> findByOrderDetailIdOrder(@Param("idorder") long idOrder); 

	@Query("select o from OrderDetail o where o.order.id=:idOrder")
	List<OrderDetail> findOrderDetailByOrderId(@Param("idOrder") long idOrder);

	@Query("select o.product from OrderDetail o where o.product.id=:idProduct")
	Product findProductByIdOrderDetail(@Param("idProduct") String idProduct);


	@Query("select new RevenueByCategory(d.product.category.name, sum(d.price*d.quantity), sum(d.quantity)) from OrderDetail d group by d.product.category.name")
	List<RevenueByCategory> RevenueByCategory();
	
//	@Query("SELECT new Top10(o.product, sum(o.quantity)) FROM Product o GROUP BY o.product ORDER BY sum(o.quantity) DESC ")
//	List<Top10> getTop10();
}
