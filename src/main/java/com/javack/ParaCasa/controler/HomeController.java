package com.javack.ParaCasa.controler;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		String nombre="Javack";
		Date hoy = new Date();
		model.addAttribute("nombre", nombre);
		model.addAttribute("hoy", hoy);
		return "home";
	}

	@GetMapping("/restaurantes")
	public String listadoRestaurantes(Model model) {
		
		List<String> restaurantes= new LinkedList<String>();
		restaurantes.add("Os Condes");
		restaurantes.add("As Mariñas");
		restaurantes.add("Casa Ramón");
		
		model.addAttribute("restaurantes", restaurantes);
		return "restaurantes";
	}

}
