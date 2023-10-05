package com.doapp.nanogear.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doapp.nanogear.service.CartService;
import com.doapp.nanogear.service.DeliveryAddressService;
import com.doapp.nanogear.service.OrderDetailService;
import com.doapp.nanogear.service.OrderService;
import com.doapp.nanogear.been.ParamService;
import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.User;
import com.doapp.nanogear.entity.Order;

import java.util.Random;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	OrderService orderService;
		
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	DeliveryAddressService deliveryAddressService;

	@Autowired
	SessionService sessionService;

	@Autowired
	ParamService paramService;

	@ResponseBody
	@GetMapping("/add/{idProduct}")
	public int addCart(Model model, @PathVariable("idProduct") String idProduct) {
		cartService.addCart(idProduct);
		sessionService.setAttribute("addCart", "Thêm vào giỏ hàng thành công.");
		return cartService.countCart();
	}

	@GetMapping("/viewcart")
	public String viewCart(Model model) {
		if (cartService.countCart() == 0) {
			model.addAttribute("countCart", cartService.countCart());
			return "noproduct";
		} else {
			model.addAttribute("countCart", cartService.countCart());
			model.addAttribute("viewProduct", cartService.getProduct());
			model.addAttribute("totalCart", cartService.getAmount());
			return "cart";
		}
	}

	@GetMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("id") String idProduct) {
		System.out.println(idProduct);
		cartService.deleteProduct(idProduct);
		return "redirect:/viewcart";
	}

	@GetMapping("/deleteallproduct")
	public String deleteAllProduct() {
		cartService.deleteAllProduct();
		return "redirect:/viewcart";
	}

	@GetMapping("/sumQty")
	public String sumQty(@RequestParam("id") String id, @RequestParam("qty") int qty, Model model) {
		System.out.println("Update qty=: "+qty+" "+"Id product =:"+id);
		cartService.sumQty(id, qty);
		model.addAttribute("message","tc");
		model.addAttribute("countCart",cartService.countCart());
		sessionService.setAttribute("successMessage", "Update giỏ hàng thành công");
		System.out.println("sss update: "+sessionService.get("successMessage"));
		return "redirect:/viewcart";
	}
	


//	@GetMapping("/sumQty")
//	public Collection<CartDTO> sumQty(@RequestParam("id") String id, @RequestParam("qty") int qty, Model model) {
//		System.out.println("Update qty=: " + qty + " " + "Id product =:" + id);
//		cartService.sumQty(id, qty);
//		model.addAttribute("message", "tc");
//		model.addAttribute("countCart", cartService.countCart());
//		session.setAttribute("successMessage", "Update giỏ hàng thành công");
//		return cartService.getProduct();
//	}
//
//	@ResponseBody
//	@GetMapping("/sumQty1")
//	public Collection<CartDTO> sumQty1() {
//
//		return cartService.getProduct();
//	}

	@GetMapping("/order")
	public String Order(Model model) {
		User user = sessionService.get("userss");
		if (user == null) {
			sessionService.setAttribute("loginCart", "Vui lòng đăng nhập để đặt hàng.");
			model.addAttribute("countCart", cartService.countCart());
			return "redirect:/formlogin";
		} else {
			model.addAttribute("totalCart", cartService.getAmount());
			model.addAttribute("addressUserId", deliveryAddressService.findByIdDeliveryAddress(user.getId()));
			model.addAttribute("countCart", cartService.countCart());
			model.addAttribute("viewProduct", cartService.getProduct());
			return "order_information";
		}
	}

	String randomMaTracking() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int length = 8;
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

	@PostMapping("/saveorder")
	public String saveOrder(Model model) {
		if(cartService.countCart() != 0) {
			String province = paramService.getString("province", "");
			String district = paramService.getString("district", "");
			String country = paramService.getString("country", "");
			String orderCode = randomMaTracking();
			Long idOrder =cartService.saveOrder(province, district, country,orderCode);
			model.addAttribute("totalorder", orderService.findTotalByIdOrder(idOrder));
			model.addAttribute("order",orderService.findOrderById(idOrder));
			model.addAttribute("detailOrder",orderDetailService.findByOrderDetailIdOrder(idOrder));
			return "OrderSuccess";
		}else {
			return "redirect:/home";
		}
	}
	
	@GetMapping("/cancelorder")
	public String CancelOrder(@RequestParam("id") Long idOrder) {
		Order ordert =	sessionService.get("Order");
		sessionService.setAttribute("cancalorder", "Hủy đơn hàng mã : "+ordert.getOrderCode()+" thành công.");
		Order order = orderService.findOrderById(idOrder);
		order.setStatus("H");
		orderService.SaveOrder(order);
		return "redirect:/user-order";
	}
}
