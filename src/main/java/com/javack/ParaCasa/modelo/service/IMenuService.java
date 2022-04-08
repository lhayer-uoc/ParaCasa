package com.javack.ParaCasa.modelo.service;

import java.util.List;

import com.javack.ParaCasa.modelo.entity.Menu;

public interface IMenuService {

	public List<Menu> listarTodos();
	public void guardar (Menu menu);
	public Menu buscarPorId(Long id);
	public void eliminar(Long id);
}
