package com.doapp.nanogear.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

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
	public List<com.doapp.nanogear.dto.RevenueByCategory> RevenueByCategory() {
		return orderDetailRepository.RevenueByCategory();
	}

	@Override
	public List<Top10> findAllProductTop10() {
		List<Top10> listTop10 = new ArrayList<>();
		int count = 0;
		for (Top10 list : orderDetailRepository.getTop10()) {
			if (count > 10) {
				break;
			}			
			listTop10.add(list);
			count++;
		}
		return listTop10;
	}
}
