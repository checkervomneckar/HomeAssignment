package com.example.demo.controller;

import org.springframework.web.bind.annotation.*; // brauche ich alle??? Ja!

import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") //that my React-frontend can get data from my backend
@RestController
@RequestMapping("/Christina/CustConsum") // only for test on Backend: getAll wird aufgerufen
public class HelloBrowserPage {
    private final CustomerRepository cstRepository;

    public HelloBrowserPage(CustomerRepository cstRepository) { 
        this.cstRepository = cstRepository;
    }
    
    /* this hello-message is shown on port 8080 */
    @GetMapping("/hello")
    private String sayHello() {
        return "Hello World here from Christinas Backend";
    }

    /* method getAll() is for my Backend-Test on port 8080 */
    @GetMapping
    public List<Customer> getAll() {
    	System.out.println("Methode getAll() wird aufgerufen.");
        return cstRepository.findAll();
    }
}