package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
    Users findUsersById(int id);
}
