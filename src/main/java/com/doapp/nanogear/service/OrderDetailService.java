package com.doapp.nanogear.service;

import java.util.List;

import com.doapp.nanogear.dto.OrderDetailDTO;
import com.doapp.nanogear.dto.RevenueByCategory;
import com.doapp.nanogear.dto.Top10;
import com.doapp.nanogear.entity.OrderDetail;
import com.doapp.nanogear.entity.Product;


public interface OrderDetailService {
	
	List<OrderDetailDTO> findByOrderDetailIdOrder(long idOrder);

	Product findProductByIdOrderDetail(String isProduct);

	List<RevenueByCategory> RevenueByCategory();

	List<OrderDetail> findOrderDetailByOrderId(long idOrder);
}
