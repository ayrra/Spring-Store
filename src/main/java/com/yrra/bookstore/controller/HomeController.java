package com.yrra.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String Index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "myAccount";
	}
	
	@RequestMapping("/forgotPassword")
	public String forgotPassword(Model model) {
		model.addAttribute("classActiveForgotPassword", true);
		return "myAccount";
	}
	
	@RequestMapping("/newAccount")
	public String NewAccount(Model model) {
		model.addAttribute("classActiveNewAccount", true);
		return "myAccount";
	}
}