package com.example.attendancetrackingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // You can re-enable CSRF for higher security if needed
//                .authorizeHttpRequests()
//                .requestMatchers("/", "/home", "/public/**").permitAll()  // Public access
//                .anyRequest().authenticated()  // Require authentication for other endpoints
//                .and()
//                .formLogin()
//                .loginPage("/login")  // Custom login page
//                .defaultSuccessUrl("/dashboard", true)  // Redirect after login success
//                .failureUrl("/login?error=true")  // Redirect to login with error on failure
//                .permitAll()  // Allow access to login page
//                .and()
//                .logout()
//                .logoutUrl("/logout")  // Custom logout URL
//                .logoutSuccessUrl("/login?logout=true")  // Redirect to login after logout
//                .permitAll();  // Allow logout without authentication
//
//        return http.build();
//    }
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrf -> csrf.disable()) // Çaktivizon CSRF për testim (aktivizo më vonë nëse duhet)
            .authorizeHttpRequests(auth -> auth
                    .anyRequest().permitAll() // Lejon të gjithë të hyjnë në çdo URL
            )
            .formLogin(form -> form.disable()) // Çaktivizon login-in
            .httpBasic(httpBasic -> httpBasic.disable()); // Çaktivizon edhe autentikimin Basic

    return http.build();
}
}
