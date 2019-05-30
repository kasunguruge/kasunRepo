package com.kasun.auth.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Userconfiguration extends GlobalAuthenticationConfigurerAdapter{

	
	PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("Kasun").
		password(passwordEncoder.encode("kasun"))
		.roles("ADMIN","USER")
		.authorities("CAN_CREATE","CAN_READ").
		and()
		.withUser("Rajitha")
		.password(passwordEncoder.encode("rajitha"))
		.roles("USER")
		.authorities("CAN_READ");
	}
}
