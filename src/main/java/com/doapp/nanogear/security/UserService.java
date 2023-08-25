package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.Users;
import com.doapp.nanogear.model.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    public List<Users> findAll() {
        return userRepo.findAll();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User: " + username + " not found!");
    }
//    public Users authenticateUser(String username, String rawPassword) {
//        Users user = userRepo.findByUsername(username);
//
//        if (user != null) {
//            if (checkPassword(rawPassword, user.getPassword())) {
//                return user;
//            }
//        }
//        return null;
//    }
//    public boolean checkPassword(String rawPassword, String encodedPassword) {
//        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
//    }
@Bean
public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
}
}