package com.indus.training.spring.impl;

import com.indus.training.spring.entity.Request;
import com.indus.training.spring.entity.Response;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.indus.training.spring.svc.ResponseHandler;

public class HtmlResponseHandler implements ResponseHandler {

    @Override
    public void generateResponse(Request request, String outputFile) throws IOException {
        Response response = new Response();
        String name = request.getFormData("name");
        String email = request.getFormData("email");

        String htmlContent = "<html>\n" +
                "<body>\n" +
                "<h2>Form Submission Successful</h2>\n" +
                "<p>Name: " + name + "</p>\n" +
                "<p>Email: " + email + "</p>\n" +
                "</body>\n" +
                "</html>";

        response.setHtmlResponse(htmlContent);

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(response.getHtmlResponse());
        writer.close();
    }
}
