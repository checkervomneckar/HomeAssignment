package com.example.demo.controller;

import com.example.demo.entity.MeteringPoint;
import com.example.demo.repository.MeteringPointRepository;
import com.example.demo.service.StatistikService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/Christina/electric")
public class StatistikController {

    public final StatistikService statistikService;
    public final MeteringPointRepository mpRepository;
    public List<List<CustomerCostDTO>> custMpCostDtoList;

    public StatistikController(StatistikService statistikService, MeteringPointRepository mpRepository) {
    	System.out.println("HALLO, StatistikController() Konstruktor wurde aufgerufen!!!!");
	   this.statistikService = statistikService;
	   this.mpRepository = mpRepository;
	}
    
    /** List of Customer-Costs: One Customer, many MeteringPoints with many Consumptions (12 months) */
    @GetMapping("/{customer_id}")                                   //pathvariable muss in Klammern Tabellenbezeichnung tragen
    public List<List<CustomerCostDTO>> getMeteringPointCostByCustomer(@PathVariable("customer_id") Long customer_id) {
    	System.out.println("HALLO, getMeteringPointCostByCustomer() wurde aufgerufen!!!!");
    	List<MeteringPoint> metPointList = this.mpRepository.findByCustomerCustomerId(customer_id);
    	this.custMpCostDtoList = new ArrayList<>(); // new for every customer, other customers' data shall not be seen
    	for (MeteringPoint metPoint : metPointList)
    	{
    		this.custMpCostDtoList.add(this.statistikService.getCalculatedCosts(metPoint.getMeteringPointId()));
    	}
    	
        return custMpCostDtoList;
    }
}
