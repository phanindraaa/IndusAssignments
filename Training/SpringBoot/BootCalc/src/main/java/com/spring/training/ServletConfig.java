package com.spring.training;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.indus.training.core.impl.CalcEncr;
import com.indus.training.core.domain.CalcEncInp;
import com.indus.training.core.domain.CalcEncOut;

import java.io.IOException;
import java.util.Arrays;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<CalculatorServlet> calculatorServlet() {
        return new ServletRegistrationBean<>(new CalculatorServlet(), "/calculate");
    }

    // Add CORS configuration for the /calculate endpoint
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:8000")); // Allow specific origin
        config.setAllowedMethods(Arrays.asList("GET", "POST"));
        config.setAllowedHeaders(Arrays.asList("Content-Type"));
        source.registerCorsConfiguration("/calculate", config); // Apply CORS to /calculate endpoint
        return new CorsFilter(source);
    }
}

class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write(
            "<html><body>" +
            "<h1>Calculator Servlet</h1>" +
            "<form method='post'>" +
            "Number 1: <input type='number' name='num1' required><br>" +
            "Number 2: <input type='number' name='num2' required><br>" +
            "Operation: <br>" +
            "<input type='radio' name='operation' value='add' required> Add<br>" +
            "<input type='radio' name='operation' value='subtract'> Subtract<br>" +
            "<input type='radio' name='operation' value='multiply'> Multiply<br>" +
            "<input type='radio' name='operation' value='divide'> Divide<br>" +
            "<input type='submit' value='Calculate'>" +
            "</form>" +
            "</body></html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");

        CalcEncr calculator = new CalcEncr();
        CalcEncInp input = new CalcEncInp();
        input.setPraam1(num1);
        input.setPraam2(num2);

        CalcEncOut result = null;

        switch (operation) {
            case "add":
                result = calculator.Addition(input);
                break;
            case "subtract":
                result = calculator.Subtract(input);
                break;
            case "multiply":
                result = calculator.Multiply(input);
                break;
            case "divide":
                result = calculator.Division(input);
                break;
        }

        resp.setContentType("text/html");
        resp.getWriter().write(
            "<html><body>" +
            "<h1>Calculation Result</h1>" +
            "<p>Number 1: " + num1 + "</p>" +
            "<p>Number 2: " + num2 + "</p>" +
            "<p>Operation: " + operation + "</p>" +
            "<p>Result: " + (result != null ? result.getResult() : "Error") + "</p>" +
            "<a href='/calculate'>Back to Calculator</a>" +
            "</body></html>"
        );
    }
}
