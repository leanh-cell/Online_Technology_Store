package com.doapp.nanogear.controller;

import com.doapp.nanogear.security.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    String randomMaTracking() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 5;
        Random random = new Random();

        String code;
        do {
            StringBuilder codeBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                codeBuilder.append(randomChar);
            }
            code = codeBuilder.toString();
        } while (trackingCodeExists(code)); // Kiểm tra nếu mã đã tồn tại
        return code;
    }

    boolean trackingCodeExists(String code) {
        return orderService.orderExistsWithCode(code);
    }
}
