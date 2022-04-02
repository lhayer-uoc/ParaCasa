package com.javack.ParaCasa.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	
	@GetMapping("/menu")
	public String home(Model model) {
		String menu="menu";
		Date hoy = new Date();
		model.addAttribute("menu", menu);
		model.addAttribute("hoy", hoy);
		return "menu";
	}
}
