package com.junittestingexam.testjunitmockitofour.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		String userPass = passwordEncoder().encode("9999");
		//String adminPassWord = passwordEncoder().encode("9999");
		auth.inMemoryAuthentication().withUser("jhon_007").password(userPass)
		//.credentialsExpired(false).accountExpired(false).accountLocked(true)
		.roles("USER").authorities("WRITE_PRIVILEGES","READ_PRIVILEGES").roles("ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
