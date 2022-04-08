package com.javack.ParaCasa.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javack.ParaCasa.modelo.entity.Usuario;
import com.javack.ParaCasa.modelo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> listarTodos() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);	
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);
	}

}
