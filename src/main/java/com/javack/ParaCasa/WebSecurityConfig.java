package com.javack.ParaCasa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.javack.ParaCasa.util.LoginSuccessMessage;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private LoginSuccessMessage successMessage;
	
	
	//Comprobamos que el usuario exista
		@Autowired
		public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {
			builder.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passEncoder)
			.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
			.authoritiesByUsernameQuery("SELECT u.username, r.rol FROM roles r INNER JOIN users u ON r.user_id=u.id WHERE u.username=?");
		}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/home", "/index", "/css/**", "/js/**", "/images/**").permitAll()
		.antMatchers("/views/menus/").hasAnyRole("USER")
		.antMatchers("/views/menus/create").hasAnyRole("ADMIN")
		.antMatchers("/views/menus/save").hasAnyRole("ADMIN")
		.antMatchers("/views/menus/edit/**").hasAnyRole("ADMIN")
		.antMatchers("/views/menus/delete/**").hasAnyRole("ADMIN")
		
		.antMatchers("/views/pedidos/").hasAnyRole("USER")
		//Los pedidos pueden ser creados y guardados también por usuarios
		.antMatchers("/views/pedidos/create").hasAnyRole("USER")
		.antMatchers("/views/pedidos/save").hasAnyRole("USER")
		.antMatchers("/views/pedidos/edit/**").hasAnyRole("ADMIN")
		.antMatchers("/views/pedidos/delete/**").hasAnyRole("ADMIN")
		
		
		.antMatchers("/views/productos/").hasAnyRole("USER")
		.antMatchers("/views/productos/create").hasAnyRole("ADMIN")
		.antMatchers("/views/productos/save").hasAnyRole("ADMIN")
		.antMatchers("/views/productos/edit/**").hasAnyRole("ADMIN")
		.antMatchers("/views/productos/delete/**").hasAnyRole("ADMIN")
		
		
		.antMatchers("/views/tipos/").hasAnyRole("USER")
		.antMatchers("/views/tipos/create").hasAnyRole("ADMIN")
		.antMatchers("/views/tipos/save").hasAnyRole("ADMIN")
		.antMatchers("/views/tipos/edit/**").hasAnyRole("ADMIN")
		.antMatchers("/views/tipos/delete/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.successHandler(successMessage)
			.loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll();
	}
	
}