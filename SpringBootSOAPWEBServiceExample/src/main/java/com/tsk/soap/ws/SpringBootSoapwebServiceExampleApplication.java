package com.tsk.soap.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

@SpringBootApplication
@ComponentScan({"com.tsk.*"})
public class SpringBootSoapwebServiceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapwebServiceExampleApplication.class, args);
	}
	
	@EnableGlobalAuthentication
    static class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
        }
    }
}
