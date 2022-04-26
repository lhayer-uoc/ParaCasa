package com.javack.ParaCasa.modelo.service;




import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.javack.ParaCasa.modelo.entity.Rol;
import com.javack.ParaCasa.modelo.entity.Usuario;
import com.javack.ParaCasa.modelo.repository.UsuarioRepository;
import com.javacl.ParaCasa.dto.UsuarioRegistroDTO;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private UsuarioRepository usuarioRepositorio;

	public UsuarioServiceImplement(UsuarioRepository usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getUsername(),
										passwordEncoder.encode(registroDTO.getPassword()), 
										registroDTO.getEnabled(), 
										registroDTO.getNombre(), 
										registroDTO.getEmail(),
										Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password invalidos");
			
		}
		return new User(usuario.getUsername(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
		
	}
	
	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol>roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRol())).collect(Collectors.toList());
		
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}
	
	

}