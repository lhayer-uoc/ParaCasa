package com.javack.ParaCasa.modelo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table (name="pedido")
public class Pedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	@JoinTable	(name="pedido_menu",
			   joinColumns= @JoinColumn(name="id_pedido"),
			   inverseJoinColumns= @JoinColumn(name="id_menu"))	
	private Set<Menu> menus;
	
	@NotNull
	private LocalDateTime fecha;
	
	
	
	private double total;
	
	
	
	
	
	//Métodos
	
	public Pedido() {}
	
	public Pedido(long id, Set<Menu> menus,@NotNull LocalDateTime fecha, double total) {
		super();
		this.id = id;
		this.menus = menus;
		this.fecha = fecha;
		this.total = total;
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", menus=" + menus + ", fecha=" + fecha + ", total="
				+ total + "]";
	}

	
	
	
		
	
}
	