package Indus.currency_conversion_service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CurrencyExchangeServiceClient {

    // List of URLs to instances for manual round-robin
    private final List<String> serviceUrls = List.of(
            "http://localhost:8000",
            "http://localhost:8001"
    );

    private final AtomicInteger counter = new AtomicInteger(0);

    public CurrencyConversionBean retrieveExchangeValue(String from, String to) {
        // Get the next URL in a round-robin fashion
        String serviceUrl = serviceUrls.get(counter.getAndIncrement() % serviceUrls.size());

        // Construct the full URL for the request
        String url = serviceUrl + "/currency-exchange/from/" + from + "/to/" + to;

        // Make a call using RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, CurrencyConversionBean.class);
    }
}
