package com.spring.training;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testGetAllEmployees() {
        String url = getBaseUrl() + "/all-employees";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById() {
        String url = getBaseUrl() + "/employee-by-id";

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Create form parameters
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("employeeId", "1");

        // Create the request entity
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // Send the request
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeByInvalidId() {
        String url = getBaseUrl() + "/employee-by-id";

        // Create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // Create form parameters
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("employeeId", "9999");

        // Create the request entity
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // Send the request
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
