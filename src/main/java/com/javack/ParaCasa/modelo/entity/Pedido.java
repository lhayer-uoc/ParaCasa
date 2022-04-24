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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
	
	private LocalDateTime fecha;
	
	
	@NotNull
	@DecimalMin("1.0") @DecimalMax("999.9")
	private double total;
	
	@NotNull
	private int id_usuario;
	
	
	
	//Métodos
	
	public Pedido() {}
	
	public Pedido(long id, Set<Menu> menus,@NotNull LocalDateTime fecha,@NotNull @DecimalMin("1.0") @DecimalMax("999.9") double total,@NotNull int id_usuario) {
		super();
		this.id = id;
		this.menus = menus;
		this.fecha = fecha;
		this.id_usuario = id_usuario;
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
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", menu=" + menus + ", fecha=" + fecha + ", id_usuario=\"\r\n"
				+ "				+ id_usuario + \", total=" + total + "]";
	}
	
		
	
}
	