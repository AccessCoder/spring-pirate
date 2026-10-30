package org.example.springpirate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.GET, "/api/hello").permitAll()
                        .requestMatchers("/api/student").authenticated()
                        .requestMatchers("/api/student/*").authenticated()
                        .requestMatchers("/api/student/*").hasAuthority("ADMIN")
                        .anyRequest().permitAll()
                )
                .oauth2Login(oauth -> oauth
                        .defaultSuccessUrl("http://localhost:5173/dashboard"))
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(
                                new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
                        ))
                .logout(logout -> logout
                        .logoutSuccessUrl("http://localhost:5173/login"));
        return http.build();
    }
}
