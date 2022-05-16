package com.javack.ParaCasa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.javack.ParaCasa.modelo.service.IUsuarioService;
import com.javack.ParaCasa.util.LoginSuccessMessage;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginSuccessMessage successMessage;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioService);
		auth.setPasswordEncoder(passwordEncoder);
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/", "/home", "/index","/registro**", "/css/**", "/js/**", "/images/**" ).permitAll()
		.antMatchers("/views/menus/").hasAnyRole("USER")
		.antMatchers("/views/menus/create").hasAnyRole("ROLE_ADMIN")
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
		.loginPage("/login")
		.successHandler(successMessage)
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
				
	}
	
}
