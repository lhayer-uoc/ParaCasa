package com.javack.ParaCasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javack.ParaCasa.modelo.entity.Menu;
import com.javack.ParaCasa.modelo.service.IMenuService;

@Controller
@RequestMapping("/views/menus")
public class MenuController {

	@Autowired
	private IMenuService menuService;
	
	@GetMapping("/")
	public String listarMenus(Model model) {
		List<Menu> listadoMenus = menuService.listarTodos();
		
		model.addAttribute("titulo", "Lista de Menus");
		model.addAttribute("menus", listadoMenus);
		return "/views/menus/listar";
	}
	
	
	@GetMapping("/create")
	public String crear() {
		return "/views/menus/frmCrear";
	}
	
}
