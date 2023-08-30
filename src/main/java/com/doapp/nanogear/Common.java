package com.doapp.nanogear;

import com.doapp.nanogear.model.respository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@ControllerAdvice
public class Common {
    @Autowired
    private CartRepository cartRepository;
    @ModelAttribute
    public void ShareData (Model model, HttpSession session){

    }
}
