package com.doapp.nanogear.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.doapp.nanogear.dto.OrderStatistics;
import com.doapp.nanogear.dto.TotalDate;
import com.doapp.nanogear.dto.TotalYear;
import com.doapp.nanogear.service.OrderDetailService;
import com.doapp.nanogear.service.OrderService;

@Controller
public class StatisticalControllerAdmin {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderDetailService orderDetailService;

	@ResponseBody
	@GetMapping("/total-year")
	public List<TotalYear> test() {
		return orderService.getTotalYear();
	}
	
	@GetMapping("/statistical")
	public String statistical(Model model) {
		Date date = new Date();
		model.addAttribute("date",new SimpleDateFormat("yyyy-MM-dd").format(date));
		return "testchart";
	}

	@GetMapping("/view-total-year")
	public String viewTotalYear() {
		return "totalyear";
	}

	@GetMapping("/renoveByCategory")
	public String viewRevenueByCategory(Model model) {
		model.addAttribute("renoveByCategory", orderDetailService.RevenueByCategory());
		return "statisticalproduct";
	}

	@GetMapping("/statisticaOrder")
	public String viewStatisticaOrder(Model model) {
		return "statisticaOrder";
	}

	@ResponseBody
	@GetMapping("/dataStatisticaOrder")
	public List<OrderStatistics> dataStatisticaOrder() {
		return orderService.getStatusOrder();
	}
		
	@ResponseBody
	@PostMapping("/viewtotaldate")
	public List<TotalDate> viewTotalDatePost(@RequestParam("date1") Optional<String> date1,
			@RequestParam("date2") Optional<String> date2, Model model) {
		return orderService.findTotalByDate(date1, date2);
	}
}
