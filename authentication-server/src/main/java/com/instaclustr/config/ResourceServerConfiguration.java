package com.instaclustr.config;



import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{
	  @RequestMapping("/publica")
	  public String publico() {
	    return "Pagina Publica";
	  }
	  @RequestMapping("/privada")
	  public String privada() {
	    return "Pagina Privada";
	  }
	  @RequestMapping("/admin")
	  public String admin() {
	    return "Pagina Administrador";
	  }

	  @GetMapping("/user/me")
	  public Principal user(Principal principal) {
	  	return principal;
	  }
	  @Override
		public void configure(HttpSecurity http) throws Exception {
			http
			.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/publica").permitAll();
//			 .anyRequest().authenticated();
			http.requestMatchers().antMatchers("/privada", "/user/me")
			.and().authorizeRequests()
			.antMatchers("/privada", "/user/me").access("hasRole('USER')")
			.and().requestMatchers().antMatchers("/admin")
			.and().authorizeRequests()
			.antMatchers("/admin").access("hasRole('ADMIN')");
		}   

}

