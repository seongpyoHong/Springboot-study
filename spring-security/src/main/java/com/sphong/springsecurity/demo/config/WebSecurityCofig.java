package com.sphong.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityCofig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/signup").permitAll()
                .anyRequest().authenticated()
                .and()
            .headers()
                .addHeaderWriter(
                    new XFrameOptionsHeaderWriter(
                            new WhiteListedAllowFromStrategy(Arrays.asList("localhost"))    // 여기!
                    )
                )
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .successForwardUrl("/home")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/home");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
