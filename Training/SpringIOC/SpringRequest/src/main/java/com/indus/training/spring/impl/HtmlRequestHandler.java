package com.indus.training.spring.impl;

import com.indus.training.spring.entity.Request;
import com.indus.training.spring.svc.RequestHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlRequestHandler implements RequestHandler {

    @Override
    public Request parseRequest(String inputFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String line;
        Request request = new Request();

        while ((line = reader.readLine()) != null) {
            if (line.contains("<input")) {
                String name = extractValue(line, "name");
                String value = extractValue(line, "value");
                request.addFormData(name, value);
            }
        }
        reader.close();
        return request;
    }

    // Helper method to extract values from HTML tags
    private String extractValue(String inputLine, String attribute) {
        String[] parts = inputLine.split(attribute + "=\"");
        if (parts.length > 1) {
            return parts[1].split("\"")[0];
        }
        return null;
    }
}
