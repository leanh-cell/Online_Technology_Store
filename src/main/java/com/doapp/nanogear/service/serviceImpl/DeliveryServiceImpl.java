package com.doapp.nanogear.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.entity.DeliveryAddress;
import com.doapp.nanogear.repository.DeliveryAddressRepository;
import com.doapp.nanogear.service.DeliveryAddressService;

import java.util.List;


@Service
public class DeliveryServiceImpl implements DeliveryAddressService{

	@Autowired
	DeliveryAddressRepository deliveryAddressRepository;

	@Override
	public List<DeliveryAddress> findByIdDeliveryAddress(String idUser) {
		return deliveryAddressRepository.findByIdDeliveryAddress(idUser);
	}

	@Override
	public DeliveryAddress findById(int id){
		return deliveryAddressRepository.findById(id);
	}

	@Override
	public void saveDeliveryAddress(DeliveryAddress deliveryAddress){
		DeliveryAddress da = new DeliveryAddress();
		da.setId(deliveryAddress.getId());
		da.setName(deliveryAddress.getName());
		da.setPhone(deliveryAddress.getPhone());
		da.setCountry(deliveryAddress.getCountry());
		da.setProvince(deliveryAddress.getProvince());
		da.setDistrict(deliveryAddress.getDistrict());
		da.setDetail(deliveryAddress.getDetail());
		da.setIsUse(deliveryAddress.getIsUse() == 1 ? 1 : deliveryAddress.getIsUse());
		da.setUser(deliveryAddress.getUser());
		deliveryAddressRepository.save(da);
	}
}
