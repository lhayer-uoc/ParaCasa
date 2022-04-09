package com.javack.ParaCasa.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javack.ParaCasa.modelo.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
