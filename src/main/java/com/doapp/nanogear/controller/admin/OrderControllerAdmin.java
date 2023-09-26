package com.doapp.nanogear.controller.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.Order;
import com.doapp.nanogear.service.OrderDetailService;
import com.doapp.nanogear.service.OrderService;
import com.doapp.nanogear.service.UserService;

@RequestMapping("/admin")
@Controller
public class OrderControllerAdmin {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	SessionService sessionService;
	
	@GetMapping("/view-all-order")
	public String doGetViewOrderAll(Model model, @RequestParam("datemin") Optional<String> datemin, @RequestParam("datemax") Optional<String> datemax, @RequestParam("p") Optional<Integer> p,
			@RequestParam("status") Optional<String> status) {
		model.addAttribute("mindate", datemin.orElse(""));
		model.addAttribute("maxdate", datemax.orElse(""));
		model.addAttribute("status", status.orElse(""));
		model.addAttribute("order",orderService.findByOrderDate(datemin, datemax,status, p));
		return "orderall";
	}
	
	@GetMapping("/view-all-order-keyword")
	public String doGetViewOrderAllKey(Model  model, @RequestParam("keyword") Optional<String> key, @RequestParam("p") Optional<Integer> p) {
		if(key.get() =="") {
			return "redirect:/admin/view-all-order";
		}else {
			model.addAttribute("order",orderService.findByIdKeyWord(key,p));
			return "orderall";
		}
	}
	
	@GetMapping("/view-order-detail")
	public String doGetOrderDetail(Model model, @RequestParam("idorder") long idOrder) {
		model.addAttribute("detailOrder",orderDetailService.findByOrderDetailIdOrder(idOrder));
		model.addAttribute("Order",orderService.findOrderById(idOrder));
		model.addAttribute("user", userService.findUserByOrderId(idOrder));
		return "orderdetail";
	}
	
	@GetMapping("/view-order-waiting")
	public String doGetViewOrderWaiting(Model model) {
		model.addAttribute("order",orderService.findByOrderStatusX());
		return "orderwaiting";
	}
	
	@GetMapping("/view-order-orderdelivered")
	public String doGetViewOrderDelivered(Model model) {
		model.addAttribute("order",orderService.findByOrderStatusN());
		return "orderdelivered";
	}
	
	@GetMapping("/view-order-ordercancel")
	public String doGetViewOrderCancel(Model model) {
		model.addAttribute("order",orderService.findByOrderStatusH());
		return "ordercancel";
	}
	
	@GetMapping("/cancel-order")
	public String doGetCancelOrder(@RequestParam("id") Long idOrder) {
		Order order = orderService.findOrderById(idOrder);
		order.setStatus("H");
		orderService.SaveOrder(order);
		sessionService.setAttribute("CancelOrder", "Đã hủy đơn hàng số "+idOrder+" thành công.");
		return "redirect:/admin/view-order-detail?idorder="+idOrder+"";
	}
	
	@GetMapping("/delivery-order")
	public String doGetDeliveryOrder(@RequestParam("id") Long idOrder) {
		Order order = orderService.findOrderById(idOrder);
		order.setStatus("N");
		orderService.SaveOrder(order);
		sessionService.setAttribute("DeliveryOrder", "Giao đơn hàng số "+idOrder+" thành công.");
		return "redirect:/admin/view-order-detail?idorder="+idOrder+"";
	}
	
	
}
