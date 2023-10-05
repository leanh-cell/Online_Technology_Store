package com.doapp.nanogear.controller;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.DeliveryAddress;
import com.doapp.nanogear.entity.User;
import com.doapp.nanogear.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeliveryAddressController {

    @Autowired
    DeliveryAddressService deliveryAddressService;

    @Autowired
    SessionService sessionService;
    @GetMapping("/add-new-address")
    public String addNewAddress(Model model){
        User userSession = sessionService.get("userss");
        if (userSession == null) {
            return "redirect:formlogin";
        }
     return "add_new_address";
    }

    @PostMapping("/save-address")
    public String saveAddress(DeliveryAddress da,Model model){
        if(da != null){
            deliveryAddressService.saveDeliveryAddress(da);
            model.addAttribute("deliveryAddress",da);
            model.addAttribute("success","thêm địa chỉ thành công");
            return "redirect:user_delivery_address";
        }
        model.addAttribute("success","Vui lòng kiểm tra lại thông tin bị thiếu");
       return null;
    }
}
