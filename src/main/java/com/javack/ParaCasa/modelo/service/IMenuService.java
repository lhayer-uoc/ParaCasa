package com.javack.ParaCasa.modelo.service;

import java.util.List;

import com.javack.ParaCasa.modelo.entity.Menu;

public interface IMenuService {

	public List<Menu> listarTodos();
	public void guardar (Menu menu);
	public Menu buscarPorId(String id);
	public void eliminar(String id);
}
