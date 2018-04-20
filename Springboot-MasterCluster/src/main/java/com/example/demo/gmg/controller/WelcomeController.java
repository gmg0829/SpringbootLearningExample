package com.example.demo.gmg.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@Value("${book.name}")
	private String message;
	@RequestMapping("/msg")
	public String welcome(Model model) {
		model.addAttribute("msg",message);
		return "welcome";
	}
}
