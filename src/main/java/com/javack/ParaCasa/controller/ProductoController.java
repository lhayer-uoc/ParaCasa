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

import com.javack.ParaCasa.modelo.entity.Producto;
import com.javack.ParaCasa.modelo.entity.Tipo;
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
	public String guardar(@Valid @ModelAttribute Producto producto, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: nuevo Producto");
			model.addAttribute("producto", producto);
			System.out.println("Hubo problemas al rellenar el formulario, intentelo de nuevo");
			return "views/productos/frmCrear";
		}

		
		productoService.guardar(producto);
		System.out.println("Producto guardado con exito");


		return "redirect:/views/productos/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idProducto, Model model) {
		
		Producto producto= null;

		//Esta comprobación sirve para que no se pueda meter en el buscador un número incorrecto
		if(idProducto > 0) {

			producto = productoService.buscarPorId(idProducto);

			if(producto== null) {
				System.err.println("error: El ID del producto no existe");

				return "redirect:/views/productos/";
			}
		}else {
			System.err.println("error: El ID del producto no cumple con los requerimientos");

			return "redirect:/views/productos/";

		}

		model.addAttribute("titulo", "Formulario: editar Producto");
		model.addAttribute("producto", producto);

		return "/views/productos/frmCrear";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idProducto) {
		
		Producto producto= null;

		//Esta comprobación sirve para que no se pueda meter en el buscador un número incorrecto
		if(idProducto > 0) {

			producto = productoService.buscarPorId(idProducto);

			if(producto == null) {
				System.err.println("error: El ID del producto no existe");

				return "redirect:/views/productos/";
			}
		}else {
			System.err.println("error: El ID del producto no cumple con los requerimientos");

			return "redirect:/views/productos/";

		}

		productoService.eliminar(idProducto);

		System.out.println("Registro de producto eliminado con exito");

		return "redirect:/views/productos/";
	}
	
	@GetMapping("/confirmDelete/{id}")
	public String pantallaEliminar(@PathVariable("id") Long id, Model modelo) {
		modelo.addAttribute("producto", productoService.buscarPorId(id));
		return "/views/productos/eliminarProducto";

	}


}