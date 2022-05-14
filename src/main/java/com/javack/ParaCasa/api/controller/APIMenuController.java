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

import com.javack.ParaCasa.modelo.entity.Menu;
import com.javack.ParaCasa.modelo.service.IMenuService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api")

public class APIMenuController {

	@Autowired
	private IMenuService menuService;
	
	@Operation(summary = "Listar todos los menús")
	@GetMapping("/menus")
	public List<Menu> listarMenus(){
		return menuService.listarTodos();
	}
	
	@Operation(summary = "Buscar un menú por id")
	@GetMapping("/menus/{menuId}")
    public Menu buscarTipo(@PathVariable Long menuId){
        Menu menu = menuService.buscarPorId(menuId);

        if(menu == null) {
            throw new RuntimeException("Menu id no encontrado -"+menuId);
        }

        return menu;
    }
	
	@Operation(summary = "Crear un menú")
	@PostMapping("/menus")
    public Menu crearMenu(@RequestBody Menu menu) {
        menuService.guardar(menu);

        return menu;

    }
	
	@Operation(summary = "Actualizar un menú por id")
	@PutMapping("/menus")
    public Menu actualizarMenu(@RequestBody Menu menu) {

        menuService.guardar(menu);

        return menu;
    }
	
	@Operation(summary = "Eliminar un menú por id")
	@DeleteMapping("menus/{menuId}")
    public String eliminarMenu(@PathVariable Long menuId) {

        Menu menu = menuService.buscarPorId(menuId);

        if(menu == null) {
            throw new RuntimeException("Menu no encontrado -"+menuId);
        }

        menuService.eliminar(menuId);

        return "Menu eliminado - "+menuId;
    }
}
