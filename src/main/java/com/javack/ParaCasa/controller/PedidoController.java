package com.javack.ParaCasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javack.ParaCasa.modelo.entity.Pedido;
import com.javack.ParaCasa.modelo.service.IPedidoService;

@Controller
@RequestMapping("/views/pedidos")
public class PedidoController {
	
	@Autowired
	private IPedidoService pedidoService;
	
	@GetMapping("/")
	public String listarPedidos(Model model) {
		
		List<Pedido> listaPedidos = pedidoService.listarTodos();
		
		model.addAttribute("titulo", "Lista de Pedidos");
		model.addAttribute("pedidos", listaPedidos);
		
		return "/views/pedidos/listarPedidos";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "/views/pedidos/frmCrear";
	}
	
	@PostMapping
	public String guardar(@ModelAttribute Pedido pedido) {
		
		pedidoService.guardar(pedido);
		System.out.println("Pedido Realizado");
		return "redirect:/views/pedidos/";
	}

}
