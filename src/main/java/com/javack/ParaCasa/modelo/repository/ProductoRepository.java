package com.javack.ParaCasa.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javack.ParaCasa.modelo.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, String> {


}