package com.javack.ParaCasa.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javack.ParaCasa.modelo.entity.Producto;
import com.javack.ParaCasa.modelo.repository.ProductoRepository;

@Service
public class ProductoServiceImplement implements IProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> listarTodos() {

		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(producto);

	}

	@Override
	public Producto buscarPorId(String id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(String id) {
		productoRepository.deleteById(id);

	}

}
