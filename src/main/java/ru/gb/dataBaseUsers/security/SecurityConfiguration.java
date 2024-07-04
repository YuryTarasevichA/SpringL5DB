package ru.gb.dataBaseUsers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/users/admin**").hasAuthority("admin")
                        .requestMatchers("/users/user**").hasAuthority("user")
//                        .requestMatchers("/dataBaseUsers/resource").permitAll()
//                        .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
        .build();
    }

}
