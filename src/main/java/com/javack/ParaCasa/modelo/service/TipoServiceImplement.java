package com.javack.ParaCasa.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javack.ParaCasa.modelo.entity.Tipo;
import com.javack.ParaCasa.modelo.repository.TipoRepository;

@Service
public class TipoServiceImplement implements ITipoService {

	@Autowired
	private TipoRepository tipoRepository;

	@Override
	public List<Tipo> listarTodos() {

		return (List<Tipo>) tipoRepository.findAll();
	}

	@Override
	public void guardar(Tipo tipo) {
		tipoRepository.save(tipo);

	}

	@Override
	public Tipo buscarPorId(String id) {
		return tipoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(String id) {
		tipoRepository.deleteById(id);

	}

}