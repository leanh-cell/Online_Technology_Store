package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.Users;
import com.doapp.nanogear.model.usesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class userService implements UserDetailsService {
    @Autowired
    private usesRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User: " + username + " not found!");
    }
}
