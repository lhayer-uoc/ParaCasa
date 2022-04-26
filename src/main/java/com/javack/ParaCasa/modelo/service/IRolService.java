package com.javack.ParaCasa.modelo.service;

import java.util.List;

import com.javack.ParaCasa.modelo.entity.Rol;



public interface IRolService {

	
	public List<Rol> listarTodos();
	public void guardar (Rol rol);
	public Rol buscarPorId(Long id);
	public void eliminar(Long id);
}
