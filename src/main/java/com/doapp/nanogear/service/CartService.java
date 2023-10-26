package com.doapp.nanogear.service;

import java.util.Collection;

import com.doapp.nanogear.dto.CartDTO;
import com.doapp.nanogear.entity.DeliveryAddress;

public interface CartService {

	void addCart(String idProduct);

	Collection<CartDTO> getProduct();

	Double getAmount();

	void deleteProduct(String idProduct);

	void deleteAllProduct();

	void sumQty(String idProduct, int qty);
	
	Long saveOrder(DeliveryAddress deliveryAddress, String orderCode);
	
	int countCart();
}
