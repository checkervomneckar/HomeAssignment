//    // USER und PASSWORD
//package com.example.demo.service;
//
//import com.example.demo.entity.Customer;
//import com.example.demo.repository.CustomerRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustDetailsService implements UserDetailsService {
//
//    private final CustomerRepository customerRepository;
//
//    public CustDetailsService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Customer customer = customerRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        return User.builder()
//                .username(customer.getUsername())
//                .password(customer.getPassword())
//                .roles("USER") // alle Customer bekommen Rolle USER
//                .build();
//    }    
//}

