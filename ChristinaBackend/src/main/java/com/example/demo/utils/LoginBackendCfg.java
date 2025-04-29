//    // USER und PASSWORD
//package com.example.demo.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.Customizer;
//
//@Configuration
//public class LoginBackendCfg {
//    
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//            .csrf(csrf -> csrf.disable())
//            .authorizeHttpRequests(auth -> auth
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults())//httpBasic -> {}) // modernes httpBasic (kein Warning mehr!)
//            .build();
//    }   
//
///*    @Bean
//    public SecurityFilterChain filterChain_deprecated(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) // deaktiviert CSRF (für APIs sinnvoll)
//            .authorizeHttpRequests(authz -> authz
//                .anyRequest().authenticated()
//            )
//            .httpBasic(); // <-- Aktiviert Basic Auth   Aber das ist DEPRECATED?!!
//
//        return http.build();
//    } */    
//}
//
