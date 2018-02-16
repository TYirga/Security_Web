package com.example.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/add","/addexperiance/**").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .httpBasic();

        http.headers().frameOptions().disable();
        http.csrf().disable();
    }





    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{


        auth.inMemoryAuthentication().
                withUser("user").password("password").authorities("USER")
                .and()
                .withUser("mgr").password("employer").authorities("ADMIN");


    }
}

