package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author <a href="zemlyanscky.grigorij@yandex.ru">Zemlyanskii Grigoriy</a> <br/>
 *         Creation date: 02/02/18.
 * @since 1.0
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity config) throws Exception {
        config
                .authorizeRequests()
                .antMatchers("/blog").permitAll()
                .antMatchers("/blog/editor").hasRole("EDITOR")
                .and()
                .formLogin().loginPage("/blog/login").defaultSuccessUrl("/blog/editor").permitAll()
                .and()
                .logout().logoutUrl("/blog/logout").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("user").password("password").roles("EDITOR");
    }
}