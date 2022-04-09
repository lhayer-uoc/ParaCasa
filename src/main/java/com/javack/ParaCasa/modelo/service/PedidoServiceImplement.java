package com.javack.ParaCasa.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javack.ParaCasa.modelo.entity.Pedido;
import com.javack.ParaCasa.modelo.repository.PedidoRepository;


@Service
public class PedidoServiceImplement implements IPedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public List<Pedido> listarTodos() {
		return (List<Pedido>) pedidoRepository.findAll();
	}

	@Override
	public void guardar(Pedido pedido) {
		pedidoRepository.save(pedido);

	}

	@Override
	public Pedido buscarPorId(int id) {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		pedidoRepository.deleteById(id);

	}

}
