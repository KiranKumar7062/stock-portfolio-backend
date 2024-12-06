package com.stockportfoliobackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Use AntPathRequestMatcher explicitly for the /api/** pattern
                        .requestMatchers(new AntPathRequestMatcher("/api/**")).permitAll()
                        // Allow access to the H2 database console
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.disable()) // Disable headers protection globally (includes frameOptions)
                .cors(cors -> {}); // Enable CORS

        return http.build();
    }
}