package com.javack.ParaCasa.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javack.ParaCasa.modelo.entity.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
	public Usuario findByUsername(String username);
	
	
	
}