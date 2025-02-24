package com.indus.training.spring.test;

import com.indus.training.spring.entity.Request;
import com.indus.training.spring.impl.HtmlRequestHandler;
import com.indus.training.spring.impl.HtmlResponseHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlRequestResponseTest {

    private HtmlRequestHandler requestHandler;
    private HtmlResponseHandler responseHandler;

    @BeforeEach
    public void setUp() {
        requestHandler = new HtmlRequestHandler();
        responseHandler = new HtmlResponseHandler();
    }

    @Test
    public void testParseRequest() throws IOException {
        // Setup input HTML file for testing
        String testInputFile = "testInput.html";
        createTestInputFile(testInputFile);

        // Parse the request
        Request request = requestHandler.parseRequest(testInputFile);

        // Assertions to validate parsed data
        assertEquals("Phani", request.getFormData("name"));
        assertEquals("Phani@gmail.com", request.getFormData("email"));

        // Clean up the test file
        new File(testInputFile).delete();
    }

    @Test
    public void testGenerateResponse() throws IOException {
        // Setup request
        Request request = new Request();
        request.addFormData("name", "Phani");
        request.addFormData("email", "Phani@gmail.com");

        // Generate response
        String testOutputFile = "testOutput.html";
        responseHandler.generateResponse(request, testOutputFile);

        // Assertions to validate output file content
        File outputFile = new File(testOutputFile);
        assertEquals(true, outputFile.exists());

        // Clean up the test file
        outputFile.delete();
    }

    // Helper method to create a sample input file
    private void createTestInputFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("<html>\n" +
                "<body>\n" +
                "<form>\n" +
                "<input type=\"hidden\" name=\"name\" value=\"Phani\">\n" +
                "<input type=\"hidden\" name=\"email\" value=\"Phani@gmail.com\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        writer.close();
    }
}
