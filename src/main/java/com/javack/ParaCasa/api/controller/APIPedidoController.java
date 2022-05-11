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

import com.javack.ParaCasa.modelo.entity.Pedido;
import com.javack.ParaCasa.modelo.service.IPedidoService;


@RestController
@RequestMapping("/api")

public class APIPedidoController {

	
	@Autowired
	private IPedidoService pedidoService;
	
	@GetMapping("/pedidos")
	public List<Pedido> listarPedidos(){
		return pedidoService.listarTodos();
	}
	
	@GetMapping("/pedidos/{pedidoId}")
    public Pedido buscarPedido(@PathVariable Long pedidoId){
        Pedido pedido = pedidoService.buscarPorId(pedidoId);

        if(pedido == null) {
            throw new RuntimeException("Pedido id no encontrado -"+pedidoId);
        }

        return pedido;
    }
	
	@PostMapping("/pedidos")
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        pedidoService.guardar(pedido);

        return pedido;

    }
	
	@PutMapping("/pedidos")
    public Pedido actualizarPedido(@RequestBody Pedido pedido) {

        pedidoService.guardar(pedido);

        return pedido;
    }
	
	@DeleteMapping("pedidos/{pedidoId}")
    public String eliminarPedido(@PathVariable Long pedidoId) {

        Pedido pedido = pedidoService.buscarPorId(pedidoId);

        if(pedido == null) {
            throw new RuntimeException("Pedido no encontrado -"+pedidoId);
        }

        pedidoService.eliminar(pedidoId);

        return "Tipo eliminado - "+pedidoId;
    }
}
