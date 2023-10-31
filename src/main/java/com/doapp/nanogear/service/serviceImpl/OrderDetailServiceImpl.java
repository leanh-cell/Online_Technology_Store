package com.doapp.nanogear.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.doapp.nanogear.entity.OrderDetail;
import com.doapp.nanogear.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.dto.OrderDetailDTO;
import com.doapp.nanogear.dto.Top10;
import com.doapp.nanogear.repository.OrderDetailRepository;
import com.doapp.nanogear.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Override
	public List<OrderDetailDTO> findByOrderDetailIdOrder(long idOrder) {
		return orderDetailRepository.findByOrderDetailIdOrder(idOrder);
	}

	@Override
	public Product findProductByIdOrderDetail (String idProduct){
		String id = idProduct;
	     return	orderDetailRepository.findProductByIdOrderDetail(idProduct);
	}
	@Override
	public List<OrderDetail> findOrderDetailByOrderId(long idOrder){
		return orderDetailRepository.findOrderDetailByOrderId(idOrder);
	}

	@Override
	public List<com.doapp.nanogear.dto.RevenueByCategory> RevenueByCategory() {
		return orderDetailRepository.RevenueByCategory();
	}


}
