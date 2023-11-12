package com.doapp.nanogear.service.serviceImpl;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.User;

import com.doapp.nanogear.repository.UserRepository;
import com.doapp.nanogear.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionService sessionService;

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findByIdAndPassword(String id, String password) {
        User user = userRepository.findIdUserById(id);
        if (user != null) {
            if (checkPassword(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }

    @Override
    public Page<User> findUserByKeyWord(Optional<String> key, Optional<Integer> p) {
        String keyword = key.orElse(sessionService.get("keywords", ""));
        sessionService.set("keywords", keyword);
        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        return userRepository.findUserByKeyWord("%" + keyword + "%", pageable);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findIdUserById(String idUser) {
        return userRepository.findIdUserById(idUser);
    }

    @Override
    public User findByUserForgotPass(String idUser) {
        return userRepository.findByUserForgotPass(idUser);
    }

    @Override
    public User findUserByToken(String token) {
        return userRepository.findUserByToken(token);
    }

    @Override
    public void saveResetPassword(String token, String password) {
        User user = userRepository.findUserByToken(token);
        String encodedPassword = passwordEncoder.encode(password);
        String tokennew = UUID.randomUUID().toString();
        if (tokennew.equals(token)) {
            tokennew = UUID.randomUUID().toString();
            user.setCode(tokennew);
            user.setPassword(encodedPassword);
            user.setActive(false);
            userRepository.save(user);
        } else if (!tokennew.equals(token)) {
            user.setCode(tokennew);
            user.setPassword(encodedPassword);
            user.setActive(false);
            userRepository.save(user);
        }
    }

    @Override
    public User findUserByOrderId(long id) {
        return userRepository.findUserByOrderId(id);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
