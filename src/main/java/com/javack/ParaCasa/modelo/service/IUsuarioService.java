package com.javack.ParaCasa.modelo.service;

import java.util.List;

import com.javack.ParaCasa.modelo.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> listarTodos();
	public void guardar(Usuario usuario);
	public Usuario buscarPorId(Long id);
	public void eliminar(Long id);
	
	
}
