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
import com.javack.ParaCasa.modelo.entity.Pedido;
import com.javack.ParaCasa.modelo.service.IMenuService;
import com.javack.ParaCasa.modelo.service.IPedidoService;

@Controller
@RequestMapping("/views/pedidos")
public class PedidoController {
	
	@Autowired
	private IPedidoService pedidoService;
	
	@Autowired
	private IMenuService menuService;
	
	@GetMapping("/")
	public String listarPedidos(Model model) {
		
		List<Pedido> listarPedidos = pedidoService.listarTodos();
		List<Menu> listadoMenus = menuService.listarTodos();
		
		model.addAttribute("titulo", "Lista de Pedidos");
		model.addAttribute("pedidos", listarPedidos);
		model.addAttribute("menus", listadoMenus);
		
		return "views/pedidos/listarPedidos";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Pedido pedido = new Pedido();
		
		model.addAttribute("titulo", "Haz tu pedido");
		model.addAttribute("menus", menuService.listarTodos());
		model.addAttribute("pedido", pedido);
		return "views/pedidos/frmCrear";
	}
	
	@PostMapping ("/save")
	public String guardar(@Valid @ModelAttribute Pedido pedido, BindingResult result, Model model) {
		
		
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Haz tu pedido");
			model.addAttribute("pedido", pedido);
			model.addAttribute("menus", menuService.listarTodos());
			System.out.println("Hubo problemas al completar el pedido, por favor intentelo de nuevo");
			return "views/pedidos/frmCrear";
		}
		
		pedidoService.guardar(pedido);
		System.out.println("Pedido Realizado");
		return "redirect:/views/pedidos/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {

		Pedido pedido = null;

		// Esta comprobación sirve para que no se pueda meter en el buscador un número incorrecto
		if (id > 0) {

			pedido = pedidoService.buscarPorId(id);

			if (pedido == null) {
				System.err.println("error: El ID del pedido no existe");

				return "redirect:/views/pedidos/";
			}
		} else {
			System.err.println("error: El ID del pedido no cumple con los requerimientos");

			return "redirect:/views/pedidos/";

		}

		model.addAttribute("titulo", "Edita tu pedido");
		model.addAttribute("pedido", pedido);
		model.addAttribute("menus", menuService.listarTodos());
		
		return "views/menus/frmCrear";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long id) {

		Pedido pedido = null;

		// Esta comprobación sirve para que no se pueda meter en el buscador un número
		// incorrecto
		if (id > 0) {

			pedido = pedidoService.buscarPorId(id);

			if (pedido == null) {
				System.err.println("error: El ID del pedido no existe");

				return "redirect:/views/pedidos/";
			}
		} else {
			System.err.println("error: El ID del pedido no cumple con los requerimientos");

			return "redirect:/views/pedidos/";

		}

		pedidoService.eliminar(id);

		System.out.println("Registro de pedido eliminado con exito");

		return "redirect:/views/pedidos/";

	}

	@GetMapping("/confirmDelete/{id}")
	public String pantallaEliminar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("pedido", pedidoService.buscarPorId(id));
		model.addAttribute("menus", menuService.listarTodos());
		return "views/pedidos/eliminarPedido";

	}

}
