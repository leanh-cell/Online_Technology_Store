package com.doapp.nanogear.service.serviceImpl;


import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.User;
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

	@Autowired
	SessionService sessionService;

	@Override
	public List<DeliveryAddress> findByIdDeliveryAddress(String idUser) {
		return deliveryAddressRepository.findByIdDeliveryAddress(idUser);
	}

	@Override
	public DeliveryAddress findById(long id){
		return deliveryAddressRepository.findById(id);
	}

	@Override
	public void saveDeliveryAddress(DeliveryAddress deliveryAddress){
		User userSession = sessionService.get("userss");
		User user = new User();
		user.setId(userSession.getId());
		DeliveryAddress da = new DeliveryAddress();
		Long id = (long) (deliveryAddressRepository.selectMaxDeliveryAddressId() == null ? 1 : deliveryAddressRepository.selectMaxDeliveryAddressId());
		da.setId(id);
		da.setName(deliveryAddress.getName());
		da.setPhone(deliveryAddress.getPhone());
		da.setCountry(deliveryAddress.getCountry());
		da.setProvince(deliveryAddress.getProvince());
		da.setDistrict(deliveryAddress.getDistrict());
		da.setWard(deliveryAddress.getWard());
		da.setDetail(deliveryAddress.getDetail());
		da.setIsUse(deliveryAddress.getIsUse() == 1 ? 1 : deliveryAddress.getIsUse());
		da.setUser(user);
		deliveryAddressRepository.save(da);
	}
}
