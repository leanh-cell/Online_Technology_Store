package com.doapp.nanogear.service;

import java.util.List;

import com.doapp.nanogear.dto.OrderDetailDTO;
import com.doapp.nanogear.dto.RevenueByCategory;
import com.doapp.nanogear.dto.Top10;


public interface OrderDetailService {
	
	List<OrderDetailDTO> findByOrderDetailIdOrder(long idOrder);
	
	List<RevenueByCategory> RevenueByCategory();
	
	List<Top10> findAllProductTop10();
	
}
