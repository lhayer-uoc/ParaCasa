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
import com.javack.ParaCasa.modelo.entity.Tipo;
import com.javack.ParaCasa.modelo.service.IMenuService;
import com.javack.ParaCasa.modelo.service.ITipoService;

@RestController
@RequestMapping("/api")

public class APIMenuController {

	@Autowired
	private IMenuService menuService;
	
	@GetMapping("/menus")
	public List<Menu> listarMenus(){
		return menuService.listarTodos();
	}
	
	@GetMapping("/menus/{menuId}")
    public Menu buscarTipo(@PathVariable Long menuId){
        Menu menu = menuService.buscarPorId(menuId);

        if(menu == null) {
            throw new RuntimeException("Menu id no encontrado -"+menuId);
        }

        return menu;
    }
	
	@PostMapping("/menus")
    public Menu crearMenu(@RequestBody Menu menu) {
        menuService.guardar(menu);

        return menu;

    }
	
	@PutMapping("/menus")
    public Menu actualizarMenu(@RequestBody Menu menu) {

        menuService.guardar(menu);

        return menu;
    }
	
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
