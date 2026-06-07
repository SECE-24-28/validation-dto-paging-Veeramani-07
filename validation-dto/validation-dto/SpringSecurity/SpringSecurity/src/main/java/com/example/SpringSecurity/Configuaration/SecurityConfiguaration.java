package com.example.SpringSecurity.Configuaration;



import org.springframework.boot.web.server.servlet.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguaration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.csrf(Customizer->Customizer.disable());
        http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(Session->Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}