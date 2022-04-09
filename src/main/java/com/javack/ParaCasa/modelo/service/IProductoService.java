package com.javack.ParaCasa.modelo.service;
import java.util.List;
import com.javack.ParaCasa.modelo.entity.Producto;

public interface IProductoService {
	public List<Producto> listarTodos();
	public void guardar (Producto tipo);
	public Producto buscarPorId(Long id);
	public void eliminar(Long id);
}