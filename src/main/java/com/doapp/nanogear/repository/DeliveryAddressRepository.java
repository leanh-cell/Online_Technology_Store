package com.doapp.nanogear.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doapp.nanogear.entity.DeliveryAddress;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long>{
	
	@Query("SELECT d FROM DeliveryAddress d WHERE d.user.id=:iduser")
	DeliveryAddress findByIdDeliveryAddress(@Param("iduser") String idUser);
	
}
