package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class SoActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoActuatorApplication.class, args);
	}

}

@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
	        .requestMatchers(EndpointRequest.to("info", "health"))
	        .permitAll()
	        .anyRequest().authenticated()
	        .and().httpBasic();
	}
	
}
