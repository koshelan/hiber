package com.example.hiber;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password("{noop}pass").roles("ALL");
        auth.inMemoryAuthentication().withUser("Petr").password("{noop}pass").roles("READ");
        auth.inMemoryAuthentication().withUser("user3").password("{noop}pass").roles("WRITE");
        auth.inMemoryAuthentication().withUser("user4").password("{noop}pass").roles("DELETE");
    }

}
