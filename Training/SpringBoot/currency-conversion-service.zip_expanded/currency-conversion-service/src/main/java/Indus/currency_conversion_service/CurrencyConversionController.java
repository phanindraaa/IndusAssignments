package Indus.currency_conversion_service;

import java.math.BigDecimal;  
import java.util.HashMap;  
import java.util.Map;  

import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RestController;  
import org.springframework.web.client.RestTemplate;  

@RestController  
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}") 
    public CurrencyConversionBean convertCurrency(
            @PathVariable String from, 
            @PathVariable String to, 
            @PathVariable BigDecimal quantity) {
        
        // Setting up variables to pass to the currency exchange service
        Map<String, String> uriVariables = new HashMap<>();  
        uriVariables.put("from", from);  
        uriVariables.put("to", to);  
        
        // Calling the currency-exchange-service
        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
                CurrencyConversionBean.class, 
                uriVariables);
        
        CurrencyConversionBean response = responseEntity.getBody();  
        
        // Creating a new response bean with the required calculations and returning it
        return new CurrencyConversionBean(
                response.getId(), 
                from, 
                to, 
                response.getConversionMultiple(), 
                quantity, 
                quantity.multiply(response.getConversionMultiple()), 
                response.getPort());  
    }  
}
