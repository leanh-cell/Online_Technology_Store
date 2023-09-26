package com.doapp.nanogear.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.entity.DeliveryAddress;
import com.doapp.nanogear.repository.DeliveryAddressRepository;
import com.doapp.nanogear.service.DeliveryAddressService;


@Service
public class DeliveryServiceImpl implements DeliveryAddressService{

	@Autowired
	DeliveryAddressRepository deliveryAddressRepository;

	@Override
	public DeliveryAddress findByIdDeliveryAddress(String idUser) {
		return deliveryAddressRepository.findByIdDeliveryAddress(idUser);
	}
	
}
