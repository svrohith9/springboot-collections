package com.example.app.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.app.student.UserRole;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public WebSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/v1/**").hasRole(UserRole.STUDENT.name())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {

		UserDetails rohith = User.builder()
				.username("svrohith9")
				.password(passwordEncoder.encode("yummy"))
//				.roles(UserRole.STUDENT.name())
				.authorities(UserRole.STUDENT.getGrantedAuthorities())
				.build();
		
		LOGGER.info("UserRohith details created");
		
		UserDetails cole = User.builder()
				.username("cole")
				.password(passwordEncoder.encode("yummy"))
//				.roles(UserRole.ADMIN.name())
				.authorities(UserRole.ADMIN.getGrantedAuthorities())
				.build();
		
		LOGGER.info("UserCole details created");
		
		UserDetails adminTrainee=User.builder()
				.username("adil")
				.password(passwordEncoder.encode("yummy"))
//				.roles(UserRole.ADMINTRAINEE.name())
				.authorities(UserRole.ADMINTRAINEE.getGrantedAuthorities())
				.build();

		LOGGER.info("UserAdil details created");
		
		return new InMemoryUserDetailsManager(rohith, cole, adminTrainee);
	}
}
