package com.doapp.nanogear.controller;

import com.doapp.nanogear.been.ParamService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DeliveryAddressController {

    @Autowired
    DeliveryAddressService deliveryAddressService;

    @Autowired
    SessionService sessionService;

    @Autowired
    ParamService paramService;

    @GetMapping("/add-new-address")
    public String addNewAddress(Model model) {
        User userSession = sessionService.get("userss");
        if (userSession == null) {
            return "redirect:formlogin";
        }
        return "add_new_address";
    }

    @PostMapping("/save-address")
    public String saveAddress(DeliveryAddress da, RedirectAttributes model) {
        String screen = paramService.getString("screen", "");
        User userSession = sessionService.get("userss");
        List<DeliveryAddress> deliveryAddressList = deliveryAddressService.findByIdUser(userSession.getId());
        if (deliveryAddressList.size() >= 5) {
            if ("addressList".equals(screen)) {
                model.addFlashAttribute("notify", "Số lượng địa chỉ của bạn đã quá giới hạn vui lòng xoá 1 địa chỉ để thêm mới.");
                return "redirect:/user-delivery-address";
            }
            model.addFlashAttribute("notify", "Số lượng địa chỉ của bạn đã quá giới hạn vui lòng xoá 1 địa chỉ để thêm mới.");
            return "redirect:selected_address";
        }

        if (da != null) {
            if (da.getName() == "" || da.getPhone() == "" || da.getProvince() == "" || da.getDistrict() == "" || da.getWard() == "") {
                if ("addressList".equals(screen)) {
                    model.addFlashAttribute("notify", "Vui lòng kiểm tra lại thông tin bị thiếu");
                    return "redirect:/user-delivery-address";
                }
                model.addFlashAttribute("notify", "Vui lòng kiểm tra lại thông tin bị thiếu");
                return "redirect:selected_address";
            }
            if ("addressList".equals(screen)) {
                model.addFlashAttribute("success", "Thêm địa chỉ thành công");
                return "redirect:/user-delivery-address";
            } else {
                deliveryAddressService.saveDeliveryAddress(da);
                model.addFlashAttribute("deliveryAddress", da);
                model.addFlashAttribute("success", "Thêm địa chỉ thành công");
                return "redirect:selected_address";
            }

        }
        if ("addressList".equals(screen)) {
            model.addFlashAttribute("notify", "Vui lòng kiểm tra lại thông tin bị thiếu");
            return "redirect:/user-delivery-address";
        }else {
            model.addFlashAttribute("notify", "Vui lòng kiểm tra lại thông tin bị thiếu");
            return "redirect:selected_address";
        }

    }
}
