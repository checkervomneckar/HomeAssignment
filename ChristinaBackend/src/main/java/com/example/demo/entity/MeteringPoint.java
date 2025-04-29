package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * And here comes the MeteringPoint Entity!
 */
@Entity
public class MeteringPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meteringPointId; //das darf NICHT metering_point_id heißen, sonst gibt es eine UnsatisfiedDependencyException!!

    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;
    
    @OneToMany(mappedBy = "meteringPoint", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Consumption> consumptions;

    // Getter & Setter
    public Long getMeteringPointId() {
        return meteringPointId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    public void setHobbies(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }    
}
