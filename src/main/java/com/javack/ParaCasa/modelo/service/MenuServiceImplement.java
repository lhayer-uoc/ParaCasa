package com.javack.ParaCasa.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javack.ParaCasa.modelo.entity.Menu;
import com.javack.ParaCasa.modelo.repository.MenuRepository;

@Service
public class MenuServiceImplement implements IMenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public List<Menu> listarTodos() {

		return (List<Menu>) menuRepository.findAll();
	}

	@Override
	public void guardar(Menu menu) {
		menuRepository.save(menu);

	}

	@Override
	public Menu buscarPorId(Long id) {
		return menuRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		menuRepository.deleteById(id);

	}

}
