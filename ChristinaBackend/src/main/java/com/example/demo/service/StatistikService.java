package com.example.demo.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.controller.CustomerCostDTO;
import com.example.demo.entity.Consumption;
import com.example.demo.repository.ConsumptionRepository;

@Service
public class StatistikService {

    private final ConsumptionRepository berechnungRepository;
    private final WebScrapingService webScrapingService;

    public StatistikService(ConsumptionRepository berechnungRepository, WebScrapingService webScrapingService) {
        this.berechnungRepository = berechnungRepository;
        this.webScrapingService = webScrapingService;
    }

    //public List<KostenInfo> berechneKosten(Long personId) {
    public List<CustomerCostDTO> getCalculatedCosts(Long meteringPointId) {
        List<Consumption> berechnungen = berechnungRepository.findByMeteringPointMeteringPointId(meteringPointId);
        Map<String, Map<String, BigDecimal>> gruppiert = new HashMap<>();

        for (Consumption b : berechnungen) {
            String address = b.getMeteringPoint().getAddress();
            String consTime = b.getConsumptionTime().toString();//format(DateTimeFormatter.ofPattern("yyyy-MM"));
            String kwhORmwh = b.getAmountUnit();

            BigDecimal preis;
			try {
				preis = webScrapingService.getPriceForTime(consTime, kwhORmwh);
			} catch (IOException e) {
				System.out.println("Christina, du hast Schrott programmiert, du darfst jetzt bei E.E. als Tellerwaescher arbeiten");
				preis = new BigDecimal(1.0); // alles kostet 1ct ;-)
			}
            BigDecimal kosten = preis.multiply(b.getAmount());

            gruppiert
                .computeIfAbsent(address, k -> new HashMap<>())
                .merge(consTime, kosten, BigDecimal::add);
        }

        return gruppiert.entrySet().stream()
            .map(e -> new CustomerCostDTO(e.getKey(), e.getValue()))
            .toList();
    }
}
