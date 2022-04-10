package com.javack.ParaCasa.modelo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import javax.persistence.Table;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;





@Entity
@Table(name="menu")
public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@DecimalMin("1.0") @DecimalMax("999.9")
	private Double precio;
	

	
	@ManyToMany
	@JoinTable(name="menu_producto",
			   joinColumns= @JoinColumn(name="id_menu"),
			   inverseJoinColumns= @JoinColumn(name="id_producto"))	
	private Set<Producto> productos;
	
	
	public Menu() {}
	
	public Menu(Long id, @NotNull @DecimalMin("1.0") @DecimalMax("999.9") Double precio, Set<Producto> productos) {
		super();
		this.id = id;
		this.precio = precio;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio=precio;
	}

	
	
	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", precio=" + precio + ", productos=" + productos + "]";
	}

	
	
	
}
