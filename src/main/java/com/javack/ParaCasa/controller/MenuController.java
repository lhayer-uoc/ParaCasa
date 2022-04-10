package com.javack.ParaCasa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javack.ParaCasa.modelo.entity.Menu;
import com.javack.ParaCasa.modelo.entity.Producto;
import com.javack.ParaCasa.modelo.service.IMenuService;
import com.javack.ParaCasa.modelo.service.IProductoService;

@Controller
@RequestMapping("/views/menus")
public class MenuController {

	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IProductoService productoService;

	@GetMapping("/")
	public String listarMenus(Model model) {
		List<Menu> listadoMenus = menuService.listarTodos();
		List<Producto> listadoProductos = productoService.listarTodos();

		model.addAttribute("titulo", "Lista de Menus");
		model.addAttribute("menus", listadoMenus);
		model.addAttribute("productos", listadoProductos);
		return "views/menus/listar";
	}

	@GetMapping("/create")
	public String crear(Model model) {

		Menu menu = new Menu();

		model.addAttribute("titulo", "Formulario: nuevo Menu");
		model.addAttribute("productos", productoService.listarTodos());
		model.addAttribute("menu", menu);

		return "views/menus/frmCrear";
	}

	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Menu menu, BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("titulo", "Formulario: nuevo Menu");
			model.addAttribute("menu", menu);
			model.addAttribute("productos", productoService.listarTodos());
			System.out.println("Hubo problemas al rellenar el formulario, intentelo de nuevo");
			return "views/menus/frmCrear";
		}

		menuService.guardar(menu);
		System.out.println("Menu guardado con exito");

		return "redirect:/views/menus/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idMenu, Model model) {

		Menu menu = null;

		// Esta comprobación sirve para que no se pueda meter en el buscador un número
		// incorrecto
		if (idMenu > 0) {

			menu = menuService.buscarPorId(idMenu);

			if (menu == null) {
				System.err.println("error: El ID del cliente no existe");

				return "redirect:/views/menus/";
			}
		} else {
			System.err.println("error: El ID del cliente no cumple con los requerimientos");

			return "redirect:/views/menus/";

		}

		model.addAttribute("titulo", "Formulario: nuevo Menu");
		model.addAttribute("menu", menu);
		model.addAttribute("productos", productoService.listarTodos());

		return "views/menus/frmCrear";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idMenu) {

		Menu menu = null;

		// Esta comprobación sirve para que no se pueda meter en el buscador un número
		// incorrecto
		if (idMenu > 0) {

			menu = menuService.buscarPorId(idMenu);

			if (menu == null) {
				System.err.println("error: El ID del cliente no existe");

				return "redirect:/views/menus/";
			}
		} else {
			System.err.println("error: El ID del cliente no cumple con los requerimientos");

			return "redirect:/views/menus/";

		}

		menuService.eliminar(idMenu);

		System.out.println("Registro de menu eliminado con exito");

		return "redirect:/views/menus/";

	}

	@GetMapping("/confirmDelete/{id}")
	public String pantallaEliminar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("menu", menuService.buscarPorId(id));
		model.addAttribute("productos", productoService.listarTodos());
		return "views/menus/eliminarMenu";

	}
}
