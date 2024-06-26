package com.example.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// @GetMapping({ "/", "/home" })
	// public String index() {
	// 	return "index";
	// }

	@GetMapping({ "/", "/home" })
	public String index(Model model) {
		model.addAttribute("home", "active");
		return "index";
	}
}
