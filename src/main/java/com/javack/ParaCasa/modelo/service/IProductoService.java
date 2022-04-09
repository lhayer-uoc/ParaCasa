package com.javack.ParaCasa.modelo.service;
import java.util.List;
import com.javack.ParaCasa.modelo.entity.Producto;

public interface IProductoService {
	public List<Producto> listarTodos();
	public void guardar (Producto tipo);
	public Producto buscarPorId(String id);
	public void eliminar(String id);
}