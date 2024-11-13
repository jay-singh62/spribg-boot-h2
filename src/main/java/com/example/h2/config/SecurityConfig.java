package com.example.h2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/book")).permitAll()
                        .anyRequest().authenticated() // Configure paths that require authentication here
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(withDefaults()) // Use `withDefaults()` instead of `jwt()`
                );

        return http.build();
    }
}