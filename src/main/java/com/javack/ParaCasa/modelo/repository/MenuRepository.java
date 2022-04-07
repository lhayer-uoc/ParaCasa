package com.javack.ParaCasa.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javack.ParaCasa.modelo.entity.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {

	
}
