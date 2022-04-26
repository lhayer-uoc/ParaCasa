package com.javack.ParaCasa.modelo.entity;

import java.io.Serializable;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import javax.persistence.Table;


import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;

	
	private Integer enabled;
	
	private String nombre;
	
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles",
			   joinColumns= @JoinColumn(name="id_usuario",referencedColumnName = "id"),
			   inverseJoinColumns= @JoinColumn(name="id_rol",referencedColumnName="id")
				)	
	private List<Rol> roles;

	

	
	
	
	
	public Usuario(Long id, @NotEmpty String username, @NotEmpty String password, Integer enabled,
			String nombre, String correo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.nombre = nombre;
		this.email = email;
	}
	
	


	public Usuario() {
		super();
	}




	public Usuario(@NotEmpty String username, @NotEmpty String password, Integer enabled, String nombre, String correo,
			List<Rol> roles) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.nombre = nombre;
		this.email = email;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled +
				", nombre=" + nombre + ", email=" + email +"]";
	}
	
	
	
}
