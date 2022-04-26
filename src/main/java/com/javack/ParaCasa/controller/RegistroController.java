package com.javack.ParaCasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.javack.ParaCasa.modelo.service.IUsuarioService;

@Controller
public class RegistroController {
	@Autowired
	private IUsuarioService servicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	

}
