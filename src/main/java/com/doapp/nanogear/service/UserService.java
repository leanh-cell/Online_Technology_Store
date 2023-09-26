package com.doapp.nanogear.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.doapp.nanogear.entity.User;

public interface UserService {
	
	User findById(String id);

	User findByIdAndPassword(String id, String password);
	
	Page<User> findUserByKeyWord(Optional<String> key,Optional<Integer> p);
	
	void saveUser(User user);
	
	User findIdUserById(String idUser);
	
	User findByUserForgotPass(String idUser);
	
	User findUserByToken(String token);
	
	void saveResetPassword(String token, String password);
	
	User findUserByOrderId(long id);
	
}
