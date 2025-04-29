//    // USER und PASSWORD
//package com.example.demo.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import javax.sql.DataSource;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//
//@Configuration
//public class UserCfg {
///*
//    @Bean
//    public UserDetailsService users() {
//        return new InMemoryUserDetailsManager(
//            User.withUsername("christina")
//                .password("test123")
//                .roles("USER")
//                .build()
//        );
//    }
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }*/
//    
//// hole die user aus der Postgres Datenbank
//    
//    @Bean
//    public UserDetailsService customers(DataSource dataSource) {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//        userDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM customers WHERE username = ?");
//    	
//        //return new JdbcUserDetailsManager(dataSource);
//        return userDetailsManager;
//    }
//
// //   @Bean
// //   public static NoOpPasswordEncoder passwordEncoder() {
// //       return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
// //   }   
//    
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//        
//}
