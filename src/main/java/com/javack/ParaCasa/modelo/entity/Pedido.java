package com.javack.ParaCasa.modelo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="pedido")
public class Pedido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int id_menu;
	private LocalDateTime fecha;
	private double total;
	private int id_usuario;
	
	//Métodos

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_menu() {
		return id_menu;
	}
	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
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
	
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", id_menu=" + id_menu + ", fecha=" + fecha + ", total=" + total + ", id_usuario="
				+ id_usuario + "]";
	}
	
		
	
}
	