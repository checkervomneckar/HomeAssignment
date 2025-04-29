package com.example.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This is the Consumption Entity. Be aware of it ;-)
 */
@Entity
public class Consumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consumptionId;

    private BigDecimal amount;
    private String amount_unit;
    private OffsetDateTime consumption_time;

    @ManyToOne
    @JoinColumn(name = "metering_point_id")
    @JsonBackReference
    private MeteringPoint meteringPoint;

    // Getter & Setter
    public Long getConsumptionId() {
        return consumptionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getAmountUnit() {
        return amount_unit;
    }

    public void setAmountUnit(String amount_unit) {
        this.amount_unit = amount_unit;
    }    

	public OffsetDateTime getConsumptionTime() {
		return consumption_time;
	}

	public void setConsumptionTime(OffsetDateTime consumption_time) {
		this.consumption_time = consumption_time;
	}

    public MeteringPoint getMeteringPoint() {
        return meteringPoint;
    }

    public void setMeteringPoint(MeteringPoint meteringPoint) {
        this.meteringPoint = meteringPoint;
    }	
}