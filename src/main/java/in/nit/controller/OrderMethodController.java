package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	/*
	 * to show the register page of OrderMethod
	 * URL:ordermethod/register
	 */
	@RequestMapping("/register")
	public String showOrderMethodPage(Model model) {
		model.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegister";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveOrderMethod(
			@ModelAttribute OrderMethod orderMethod,
			Model model) {

		Integer id=service.saveOrderMethod(orderMethod);
		String message="OrderMethod      '"+id+"' updated...";
		model.addAttribute("message",message);
		return "OrderMethodRegister";

	}


}
