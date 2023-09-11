package com.doapp.nanogear.security;

import com.doapp.nanogear.model.data.ContactUser;
import com.doapp.nanogear.model.respository.ContactUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactUserService {
    private final ContactUserRepository contactUserRepository;

    @Autowired
    public ContactUserService(ContactUserRepository contactUserRepository) {
        this.contactUserRepository = contactUserRepository;
    }

    @Transactional
    public ContactUser getUserInfoByUserId(int userId) {
        return contactUserRepository.findContactUserByUserId(userId);
    }

    @Transactional
    public void saveUserInfo(ContactUser contactUser) {
        contactUserRepository.save(contactUser);
    }
}
