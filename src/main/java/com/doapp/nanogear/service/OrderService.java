package com.doapp.nanogear.service;

import java.util.List;
import java.util.Optional;

import com.doapp.nanogear.dto.TotalMonth;
import org.springframework.data.domain.Page;

import com.doapp.nanogear.dto.OrderStatistics;
import com.doapp.nanogear.dto.TotalDate;
import com.doapp.nanogear.dto.TotalYear;
import com.doapp.nanogear.entity.Order;

public interface OrderService {
	
	List<Order> getAllOrder();
	
	List<Order> findByOrderUserId(String userid);
	
	Order findOrderById(Long idOrder);
	
	Double findTotalByIdOrder(Long idOrder);
	
	void SaveOrder(Order order);
	
	List<Order> findByOrderStatusX();
	
	List<Order> findByOrderStatusN();
	
	List<Order> findByOrderStatusH();
	
	Page<Order> findAllOrder(Optional<Integer> p);
	
	Page<Order> findByOrderDate(Optional<String> minDate, Optional<String> maxDate, Optional<String> status, Optional<Integer> p );
	
	List<TotalYear> getTotalYear();

	List<TotalMonth> getTotalMonth();

	List<OrderStatistics> getStatusOrder();
	
	Page<Order> findByIdKeyWord(Optional<String> id, Optional<Integer> p);
	
	List<TotalDate> findTotalByDate(Optional<String> date1, Optional<String> date2);

	List<Order> findOrderStatusXByUserId(String userid);

	List<Order> findOrderStatusNByUserId(String userid);

	List<Order> findOrderStatusHByUserId(String userid);

	boolean orderExistsWithCode(String code);

	long getTotalOrderCount();

	long getTotalOrderX();

	long getTotalOrderN();

	long getTotalOrderH();
}
