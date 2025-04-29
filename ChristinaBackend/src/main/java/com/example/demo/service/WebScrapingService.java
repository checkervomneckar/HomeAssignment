package com.example.demo.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;

/**
 *   This class has a method to fetch from the given url parameters like centsPerKwh
 *   It is a JSON-tree, as I found out... need a parser in my Scraper
 *   
 *   {
 *    "centsPerKwh": 10.3712,
 *    "centsPerKwhWithVat": 12.652975,
 *    "eurPerMwh": 103.7129,
 *    "eurPerMwhWithVat": 126.529758,
 *    "fromDateTime": "2025-04-25T00:00:00+03:00",
 *    "toDateTime": "2025-04-25T23:59:59.999999999+03:00"
 *  }  
 */
@Service
public class WebScrapingService {
	private BigDecimal bdPriceCtPerKwh;
	private BigDecimal bdPriceCtPerMwh;
	
    /* now must get the kwh/Mwh-price from estfee.elering.ee */
    //public List<String> scrapePrices() throws IOException {
    public BigDecimal getPriceForTime(String consTime, String kwhORmwh) throws IOException {
    	System.out.println("ich bin in WebScrapingService.getPriceForTime()");
 
//example:
//http://localhost:8080/Christina/electric?url=https://estfeed.elering.ee/api/public/v1/energy-price/electricity?startDateTime=2025-04-25T00:00:00Z&endDateTime=2025-04-26T00:00:00Z
        String url = "https://estfeed.elering.ee/api/public/v1/energy-price/electricity?startDateTime="+consTime+"&endDateTime="+consTime;
        System.out.println("Die URL sieht so aus: "+url);
                
        String json = Jsoup.connect(url)  // JSON-Daten als String holen
        	    .ignoreContentType(true)  // wichtig
        	    .userAgent("Mozilla/5.0") // falls die Seite sonst blockiert
        	    .execute()
        	    .body();

        // Get the JSON-Tree
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        // Felder durchsuchen:
        for (JsonNode priceEntry : rootNode) {
            String priceCtPerKwh = priceEntry.get("centsPerKwh").asText(); // Beispiel-Feldname
            String priceEurPerMwh = priceEntry.get("eurPerMwh").asText(); // Beispiel
            bdPriceCtPerKwh =  new BigDecimal(priceCtPerKwh); // das geht bestimmt schoener, aber keine Zeit..
            bdPriceCtPerMwh =  new BigDecimal(priceEurPerMwh);            
        } 
        
        if (kwhORmwh.equals("Mwh"))
        {
        	return bdPriceCtPerMwh;
        }
        //else ;-) 
        return bdPriceCtPerKwh;
    }      
}
