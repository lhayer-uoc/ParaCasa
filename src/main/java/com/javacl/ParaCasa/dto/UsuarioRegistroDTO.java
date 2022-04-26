package com.javacl.ParaCasa.dto;

public class UsuarioRegistroDTO {

	private Long id;
	private String username;
	private String password;
	private Integer enabled;
	private String nombre;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UsuarioRegistroDTO(Long id, String username, String password, Integer enabled, String nombre,
			String correo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.nombre = nombre;
		this.email = email;
	}

	public UsuarioRegistroDTO(String username, String password, Integer enabled, String nombre, String correo) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.nombre = nombre;
		this.email = email;
	}

	public UsuarioRegistroDTO(String password) {
		super();
		this.password = password;
	}

	public UsuarioRegistroDTO() {
		super();
	}

}
