package com.app.bootApp.spring_cofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("12345")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("12345")
                .roles("ADMIN")
                .and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/users/**")
                .access("hasAnyRole('ADMIN')")
                .mvcMatchers("/rest/**")
                .access("hasAnyRole('ADMIN')")
                .antMatchers("/*")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/perform_login")
                .failureForwardUrl("/login?error=true")
                .defaultSuccessUrl("/", false)
                .and()
                .logout().logoutUrl("/perform_logout").logoutSuccessUrl("/");
    }
}
