package com.doapp.nanogear.model.DTO;

import com.doapp.nanogear.model.data.ContactUser;
import com.doapp.nanogear.model.data.User;

public class UserDTO {
    private User user;
    private ContactUser contactUser;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ContactUser getContactUser() {
        return contactUser;
    }

    public void setContactUser(ContactUser contactUser) {
        this.contactUser = contactUser;
    }
// getters và setters cho user và contactUser
}