package com.javack.ParaCasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.javack.ParaCasa.modelo.entity.Usuario;
import com.javack.ParaCasa.modelo.service.IUsuarioService;



@Controller
@RequestMapping("views/usuarios")
public class UsuarioController {

		@Autowired
		private IUsuarioService usuarioService;
		
		@GetMapping("/")
		public String listarUsuarios(Model model) {
			List<Usuario> listadoUsuarios = usuarioService.listarTodos();
			
			model.addAttribute("titulo", "Lista de Usuarios");
			model.addAttribute("usuarios", listadoUsuarios);
			return "views/usuarios/listar";
		}
		
	
}
