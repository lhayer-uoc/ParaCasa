package com.javack.ParaCasa.modelo.service;



import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.javack.ParaCasa.modelo.entity.Usuario;
import com.javacl.ParaCasa.dto.UsuarioRegistroDTO;



public interface IUsuarioService extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
}
