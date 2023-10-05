package com.doapp.nanogear.service;
import com.doapp.nanogear.entity.DeliveryAddress;
import com.doapp.nanogear.entity.User;

import java.util.List;

public interface DeliveryAddressService {
	
	List<DeliveryAddress> findByIdDeliveryAddress(String idUser);

	DeliveryAddress findById(int id);

	void saveDeliveryAddress(DeliveryAddress deliveryAddress);
}
