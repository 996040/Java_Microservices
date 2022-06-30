package com.zensar.secure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception{
		
		http
		
		    .authorizeRequests()
		    .antMatchers("/home","/login","/register").permitAll()
		    .anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic()
		    .and()
            .formLogin();	
		
	}
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("Neeraj").password(this.passwordEncoder().encode("xyz")).roles("Normal");
		auth.inMemoryAuthentication().withUser("Rohit").password(this.passwordEncoder().encode("abc")).roles("Admin");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
	

}
