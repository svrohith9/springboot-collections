package com.example.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.app.student.UserPermission;
import com.example.app.student.UserRole;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
		.antMatchers(HttpMethod.DELETE,"management/api/v1/**").hasAnyAuthority(UserPermission.COURSE_WRITE.name())
		.antMatchers(HttpMethod.PUT,"management/api/v1/**").hasAnyAuthority(UserPermission.COURSE_WRITE.name())	
		.antMatchers(HttpMethod.POST,"management/api/v1/**").hasAnyAuthority(UserPermission.COURSE_WRITE.name())
		.antMatchers(HttpMethod.GET,"management/api/v1/**").hasAnyRole(UserRole.ADMIN.name(), UserRole.ADMINTRAINEE.name())
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
				.password(passwordEncoder.encode("saynada"))
//				.roles(UserRole.STUDENT.name())
				.authorities(UserRole.STUDENT.getAuthorities())
				.build();
		
		UserDetails cole = User.builder()
				.username("cole")
				.password(passwordEncoder.encode("butterfly"))
//				.roles(UserRole.ADMIN.name())
				.authorities(UserRole.ADMIN.getAuthorities())
				.build();
		
		UserDetails adminTrainee=User.builder()
				.username("adil")
				.password(passwordEncoder.encode("yummy"))
//				.roles(UserRole.ADMINTRAINEE.name())
				.authorities(UserRole.ADMINTRAINEE.getAuthorities())
				.build();

		return new InMemoryUserDetailsManager(rohith, cole, adminTrainee);
	}
}
