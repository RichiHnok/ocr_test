package com.sensors.ocr_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
			.csrf(t -> t.disable())
			.authorizeHttpRequests(registry -> {
				// registry.requestMatchers("/home", "/register/**").permitAll();
				registry.requestMatchers("/admin/**").hasRole("ADMIN");
				registry.requestMatchers("/sensors/**").hasRole("USER");
				registry.anyRequest().authenticated();
			})
			.formLogin(formLogin -> formLogin.permitAll())
			.build();
	}

	@Bean
	public UserDetailsService userDetailsService(){
		UserDetails normalUser = User.builder()
			.username("user")
			.password("$2a$12$hRG3kjtvWumqidgdxZpO2eseI3WqluwlJBzAwJBvebFrOpakCN90W")
			.roles("USER")
			.build();
		UserDetails adminUser = User.builder()
			.username("admin")
			.password("$2a$12$cuyu4yp4AyLtM4e66vUV3upufn7xLGp9TtFLtyLsyYfbonTlyPYTi")
			.roles("ADMIN", "USER")
			.build();
		return new InMemoryUserDetailsManager(normalUser, adminUser);
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
