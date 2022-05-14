package com.javack.ParaCasa.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javack.ParaCasa.modelo.entity.Tipo;
import com.javack.ParaCasa.modelo.service.ITipoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")

public class APITipoController {
	@Autowired
	private ITipoService tipoService;
	
	@Operation(summary = "Listar todos los tipos")
	@GetMapping("/tipos")
	public List<Tipo> listarTipos(){
		return tipoService.listarTodos();
	}
	
	@Operation(summary = "Buscar un tipo por id")
	@GetMapping("/tipos/{tipoId}")
    public Tipo buscarTipo(@PathVariable Long tipoId){
        Tipo tipo = tipoService.buscarPorId(tipoId);

        if(tipo == null) {
            throw new RuntimeException("Tipo id no encontrado -"+tipoId);
        }

        return tipo;
    }
	
	@Operation(summary = "Crear un tipo")
	@PostMapping("/tipos")
    public Tipo crearTipo(@RequestBody Tipo tipo) {
        tipoService.guardar(tipo);

        return tipo;

    }
	
	@Operation(summary = "Actualizar un tipo")
	@PutMapping("/tipos")
    public Tipo actualizarTipo(@RequestBody Tipo tipo) {

        tipoService.guardar(tipo);

        return tipo;
    }
	
	@Operation(summary = "Eliminar un tipo por id")
	@DeleteMapping("tipos/{tipoId}")
    public String eliminarTipo(@PathVariable Long tipoId) {

        Tipo tipo = tipoService.buscarPorId(tipoId);

        if(tipo == null) {
            throw new RuntimeException("Tipo no encontrado -"+tipoId);
        }

        tipoService.eliminar(tipoId);

        return "Tipo eliminado - "+tipoId;
    }
}
