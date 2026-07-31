package com.example.demo.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "redirect:/book-shop";
	}
	@GetMapping("/book-shop")
	public String home(){
		return "home";
	}
}
