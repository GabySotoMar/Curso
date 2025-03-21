package com.mx.APIGatwey.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.ws.rs.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	/*
	//Metodo con usuario y contraseña configurados en memoria
	
	@Bean
	UserDetailsService userdetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(
					User.withDefaultPasswordEncoder()
					.username("user")
					.password("1234")
					.roles("USER")
					.build()
				);
		return manager;
	}
	

	//METODO PARA AGREGAR SEGURIDAD BASICA PARA TODAS LAS PETICIONES "BasicAuth"
	HttpBasicConfigurer<HttpSecurity> httpBasicConfigurer(HttpSecurity http) throws Exception{
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic();
	}
	*/
	//METODO UTILIZADO PARA TRABAJAR CON LOS FILTROS DE SEGURIDAD DE SPRING SECURITY
	//SecurityFilterChain
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		//si se trabaja con un api es necesario deshabilitar el csrf
		.authorizeHttpRequests(
				authorize -> authorize
				.requestMatchers(HttpMethod.GET, "/Tienda/Clientes/**").authenticated()
				//si quito el get si permite acceder aqui yo puedo cambiar para restringir el acceso al get, post, put o lo que yo quiera
				//HttpMethod.GET, "/Tienda/Clientes/**"
				.requestMatchers("/Tienda/Productos/**").authenticated()
				.anyRequest().denyAll()
				//URL permitidos
				
				)
		.formLogin().and()
		.httpBasic();
		
		return http.build();
	}
}
