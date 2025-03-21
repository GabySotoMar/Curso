package com.mx.APIGateway2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.ws.rs.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				// si se trabaja con un api es necesario deshabilitar el csrf
				.authorizeHttpRequests
				(authorize -> authorize
						.requestMatchers(HttpMethod.GET, "/Sala/**").authenticated()
						.requestMatchers(HttpMethod.GET, "/Boleto/**").authenticated()
						.requestMatchers(HttpMethod.POST, "/Sala/**").authenticated()
						.requestMatchers(HttpMethod.POST, "/Boleto/**").authenticated()

						.anyRequest().denyAll())
				.formLogin().and().httpBasic();

		return http.build();
	}

}
