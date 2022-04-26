/*package com.javack.ParaCasa.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javack.ParaCasa.modelo.entity.Usuario;
import com.javack.ParaCasa.modelo.service.IUsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/registro")
	public String registroForm(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "registro";
	}
}	
	/*
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "redirect:/registro";
		}else {
			model.addAttribute("usuario", usuarioService.registrar(usuario));
		}
		
		return "redirect:/login";
	} */
	
	/*@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout,
			Model model, Principal principal, RedirectAttributes attribute) {
		if(error != null) {
			model.addAttribute("error", "Error de acceso: Usuario y/o contraseña incorrectos");
		}
		
		if(principal != null) {
			attribute.addFlashAttribute("warning", "ATENCION, ya ha iniciado sesión");
					return "redirect:/home";
		}
		
		if(logout != null) {
			model.addAttribute("success", "HA FINALIZADO SESION CON EXITO");
		}
		return "login";
	}
}*/
