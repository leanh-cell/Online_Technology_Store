package com.doapp.nanogear.model;

import com.doapp.nanogear.model.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usesRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
