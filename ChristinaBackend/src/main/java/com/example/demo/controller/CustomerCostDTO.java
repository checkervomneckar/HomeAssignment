package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.Map;

public class CustomerCostDTO {
    private String meteringPointAddr;
    //private BigDecimal costs;
    private Map<String, BigDecimal> costsPerMonth;

    public CustomerCostDTO(String meteringPointAddr, Map<String, BigDecimal> costsPerMonth) {
        this.meteringPointAddr = meteringPointAddr;
        this.costsPerMonth = costsPerMonth;
    }

	/**
	 * @return the meteringPoint
	 */
	public String getMeteringPointAddr() {
		return meteringPointAddr;
	}

	/**
	 * @param meteringPoint the meteringPoint to set
	 */
	public void setMeteringPointAddr(String meteringPointAddr) {
		this.meteringPointAddr = meteringPointAddr;
	}

	/**
	 * @return the costs per month
	 */
	public Map<String, BigDecimal> getCostsPerMonth() {
		return this.costsPerMonth;
	}

	/**
	 * @param costs the costs to set
	 */
	public void setCosts(Map<String, BigDecimal> costsPerMonth) {
		this.costsPerMonth = costsPerMonth;
	}
    
}


