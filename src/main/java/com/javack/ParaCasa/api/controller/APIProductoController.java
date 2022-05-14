package com.javack.ParaCasa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javack.ParaCasa.modelo.entity.Producto;
import com.javack.ParaCasa.modelo.service.IProductoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")

public class APIProductoController {
	@Autowired
	private IProductoService productoService;

	@Operation(summary = "Listar todos los productos")
	@GetMapping("/")
	public List<Producto> listarProductos() {
		return productoService.listarTodos();
	}
	
	@Operation(summary = "Buscar un producto por id")
	@GetMapping("/productos/{productoId}")
    public Producto buscarProducto(@PathVariable Long productoId){
        Producto producto= productoService.buscarPorId(productoId);

        if(producto == null) {
            throw new RuntimeException("Producto id no encontrado -"+productoId);
        }

        return producto;
    }


	@Operation(summary = "Crear un producto")
	@PostMapping("/productos")
    public Producto crearProducto(@RequestBody Producto producto) {
        productoService.guardar(producto);

        return producto;

    }
	
	@Operation(summary = "Actualizar un producto")
	@PutMapping("/productos")
    public Producto actualizarProducto(@RequestBody Producto producto) {

        productoService.guardar(producto);

        return producto;
    }
	
	@Operation(summary = "Eliminar un producto por id")
	@DeleteMapping("productos/{productoId}")
    public String eliminarProducto(@PathVariable Long productoId) {

        Producto producto = productoService.buscarPorId(productoId);

        if(producto == null) {
            throw new RuntimeException("Producto no encontrado -"+productoId);
        }

        productoService.eliminar(productoId);

        return "Producto eliminado - "+productoId;
    }
}
