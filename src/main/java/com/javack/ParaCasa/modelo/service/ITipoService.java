package com.javack.ParaCasa.modelo.service;
import java.util.List;
import com.javack.ParaCasa.modelo.entity.Tipo;

public interface ITipoService {
	public List<Tipo> listarTodos();
	public void guardar (Tipo tipo);
	public Tipo buscarPorId(String id);
	public void eliminar(String id);
}