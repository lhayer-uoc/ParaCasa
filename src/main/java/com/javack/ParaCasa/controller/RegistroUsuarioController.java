package com.javack.ParaCasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javack.ParaCasa.modelo.service.UsuarioServiceImplement;
import com.javacl.ParaCasa.dto.UsuarioRegistroDTO;


@Controller
@RequestMapping("/registro")
public class RegistroUsuarioController {

	private UsuarioServiceImplement usuarioService;

	public RegistroUsuarioController(UsuarioServiceImplement usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	

	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioRegistro() {
		
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		
		usuarioService.guardar(registroDTO);
		return "redirect:/registro?exito";
		
	}
}
