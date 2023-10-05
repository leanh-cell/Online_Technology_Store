package com.doapp.nanogear.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.doapp.nanogear.entity.DeliveryAddress;

import java.util.List;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long>{
	
	@Query("SELECT d FROM DeliveryAddress d WHERE d.user.id=:iduser")
	List<DeliveryAddress> findByIdDeliveryAddress(@Param("iduser") String idUser);

	@Query("select d from DeliveryAddress d where d.id =:id")
	DeliveryAddress findById(@Param("id") int id);
}
