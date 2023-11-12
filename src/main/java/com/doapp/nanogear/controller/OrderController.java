package com.doapp.nanogear.controller;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.User;
import com.doapp.nanogear.service.OrderDetailService;
import com.doapp.nanogear.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @Autowired
    SessionService sessionService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/order-waiting")
    public String doGetViewOrderWaiting(Model model) {
        User userSession = sessionService.get("userss");
        if (userSession == null) {
            return "redirect:formlogin";
        }

        model.addAttribute("orderX",orderService.findOrderStatusXByUserId(userSession.getId()));

        return "user_order_waiting";
    }

    @GetMapping("/order-delivered")
    public String doGetViewOrderDelivered(Model model) {
        User userSession = sessionService.get("userss");
        if (userSession == null) {
            return "redirect:formlogin";
        }
        model.addAttribute("orderN",orderService.findOrderStatusNByUserId(userSession.getId()));
        return "user_order_delivered";
    }

    @GetMapping("/order-cancel")
    public String doGetViewOrderCancel(Model model) {
        User userSession = sessionService.get("userss");
        if (userSession == null) {
            return "redirect:formlogin";
        }
        model.addAttribute("orderH",orderService.findOrderStatusHByUserId(userSession.getId()));
        return "user_order_cancel";
    }

}
