package com.javack.ParaCasa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javack.ParaCasa.modelo.entity.Tipo;
import com.javack.ParaCasa.modelo.service.ITipoService;

@Controller
@RequestMapping("/views/tipos")
public class TipoController {

	@Autowired
	private ITipoService tipoService;

	@GetMapping("/")
	public String listarTipos(Model model) {
		List<Tipo> listadoTipos = tipoService.listarTodos();

		model.addAttribute("titulo", "Lista de Tipos");
		model.addAttribute("tipos", listadoTipos);
		return "/views/tipos/listar";
	}


	@GetMapping("/create")
	public String crear(Model model) {

		Tipo tipo = new Tipo();


		model.addAttribute("titulo", "Formulario: nuevo Tipo");
		model.addAttribute("tipo", tipo);

		return "/views/tipos/frmCrear";
	}


	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Tipo tipo, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: nuevo Tipo");
			model.addAttribute("tipo", tipo);
			System.out.println("Hubo problemas al rellenar el formulario, intentelo de nuevo");
			return "views/tipos/frmCrear";
		}

		tipoService.guardar(tipo);
		System.out.println("Tipo guardado con exito");


		return "redirect:/views/tipos/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idTipo, Model model) {

		Tipo tipo = null;

		//Esta comprobación sirve para que no se pueda meter en el buscador un número incorrecto
		if(idTipo > 0) {

			tipo = tipoService.buscarPorId(idTipo);

			if(tipo== null) {
				System.err.println("error: El ID del tipo no existe");

				return "redirect:/views/tipos/";
			}
		}else {
			System.err.println("error: El ID del tipo no cumple con los requerimientos");

			return "redirect:/views/tipos/";

		}
		
		model.addAttribute("titulo", "Formulario: editar Tipo");
		model.addAttribute("tipo", tipo);
		
		return "/views/tipos/frmCrear";
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idTipo) {
		
		Tipo tipo= null;

		//Esta comprobación sirve para que no se pueda meter en el buscador un número incorrecto
		if(idTipo > 0) {

			tipo = tipoService.buscarPorId(idTipo);

			if(tipo == null) {
				System.err.println("error: El ID del tipo no existe");

				return "redirect:/views/tipos/";
			}
		}else {
			System.err.println("error: El ID del tipo no cumple con los requerimientos");

			return "redirect:/views/tipos/";

		}
		
		

		tipoService.eliminar(idTipo);

		System.out.println("Registro de tipo eliminado con exito");

		return "redirect:/views/tipos/";
	}


}