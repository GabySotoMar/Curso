package com.mx.SalaCine.Config;




//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	/*
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
*/
}
