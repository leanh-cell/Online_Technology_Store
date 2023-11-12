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
	public List<DeliveryAddress> findByIdUser(String idUser) {
		return deliveryAddressRepository.findByIdUser(idUser);
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
		if (deliveryAddress.getIsUse() == 0) {
			List<DeliveryAddress> deliveryAddressList = deliveryAddressRepository.findByIdUser(userSession.getId());
			for (DeliveryAddress address : deliveryAddressList) {
				address.setIsUse(1);
			}
			deliveryAddressRepository.saveAll(deliveryAddressList);
		}
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
