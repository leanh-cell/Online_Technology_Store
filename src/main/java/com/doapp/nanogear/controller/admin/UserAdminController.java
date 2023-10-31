package com.doapp.nanogear.controller.admin;

import java.util.Optional;

import com.doapp.nanogear.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.doapp.nanogear.been.SessionService;
import com.doapp.nanogear.entity.User;
import com.doapp.nanogear.service.UserService;

@RequestMapping("/admin")
@Controller
public class UserAdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SessionService sessionService;

	@Autowired
	OrderService orderService;


	@GetMapping("/dashboard")
	public String dashboard (Model model) {
//		model.addAttribute("user", userService.findUserByKeyWord(key,p));
		model.addAttribute("orderX",orderService.getTotalOrderX());
		model.addAttribute("orderN",orderService.getTotalOrderN());
		model.addAttribute("orderH",orderService.getTotalOrderH());

		return "statistical";
	}
	@GetMapping("/user_management")
	public String doGetAllUser(Model model, Optional<Integer> p,@RequestParam("keyword") Optional<String> key) {
		model.addAttribute("user", userService.findUserByKeyWord(key,p));
		return "user_management";
	}
	
	@GetMapping("/edituseradmin")
	public String editUser(@RequestParam("id") String id, Model model) {
		model.addAttribute("user", userService.findById(id));
		return"updateuser";
	}
	
	@PostMapping("/updateuseradmin")
	public String updateUser(User u, Model model) {
		
		User user = userService.findIdUserById(u.getId());
		user.setName(u.getName());
		user.setEmail(u.getEmail());
		user.setPhone(u.getPhone());
		user.setAddress(u.getAddress());
		System.out.println("IS: "+u.isRole());
		user.setRole(u.isRole());
		userService.saveUser(user);
		model.addAttribute("user",u);
		model.addAttribute("insertuser", "Cập nhật user thành công");
		return "updateuser";
	}
	
	@GetMapping("/creatuser")
	public String createUser( User user, Model model) {
		model.addAttribute("hidebutton", "hidden");
		return "edituseradmin";
	}
	
	@PostMapping("/insertuser")
	public String insertUser( User u, Model model) {
		User user = userService.findIdUserById(u.getId());
		if(user == null) {
			u.setActive(false);
			u.setCode("");
			userService.saveUser(u);
			model.addAttribute("insertuser", "Thêm user thành công");
		}else {
			model.addAttribute("insertuser", "Mã user đã tồn tại.");
		}
		return "edituseradmin";
	}
}
