package com.javack.ParaCasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javack.ParaCasa.modelo.entity.Producto;
import com.javack.ParaCasa.modelo.service.IProductoService;

@Controller
@RequestMapping("/views/productos")
public class ProductoController {

	@Autowired
	private IProductoService productoService;

	@GetMapping("/")
	public String listarTipos(Model model) {
		List<Producto> listadoProductos = productoService.listarTodos();

		model.addAttribute("titulo", "Lista de Productos");
		model.addAttribute("productos", listadoProductos);
		return "/views/productos/listar";
	}


	@GetMapping("/create")
	public String crear(Model model) {

		Producto producto = new Producto();


		model.addAttribute("titulo", "Formulario: nuevo Producto");
		model.addAttribute("producto", producto);

		return "/views/productos/frmCrear";
	}


	@PostMapping("/save")
	public String guardar(@ModelAttribute Producto producto) {

		productoService.guardar(producto);
		System.out.println("Producto guardado con exito");


		return "redirect:/views/productos/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") String idProducto, Model model) {

		Producto producto= productoService.buscarPorId(idProducto);


		model.addAttribute("titulo", "Formulario: editar Producto");
		model.addAttribute("producto", producto);

		return "/views/productos/frmCrear";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") String idProducto) {

		productoService.eliminar(idProducto);

		System.out.println("Registro de producto eliminado con exito");

		return "redirect:/views/productos/";
	}


}
