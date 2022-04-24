package com.javack.ParaCasa.modelo.service;

import java.util.List;

import com.javack.ParaCasa.modelo.entity.Pedido;

public interface IPedidoService {
	public List<Pedido> listarTodos();
	public void guardar(Pedido pedido);
	public Pedido buscarPorId(long id);
	public void eliminar (long id);
	

}
