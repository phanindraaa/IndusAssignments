package com.spring.training;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Configuration
@RestController
public class ResumeServletConfig {

    @GetMapping("/")
    public String home() {
        return "Welcome to my resume application! Access /resume to view and update my resume.";
    }

    @Bean
    public ServletRegistrationBean<ResumeServlet> resumeServletBean() {
        return new ServletRegistrationBean<>(new ResumeServlet(), "/resume");
    }
}

class ResumeServlet extends HttpServlet {

    private String name = "Venkata Sai Ginjupalli";
    private String email = "venkatasai.g@example.com";
    private String phone = "(123) 456-7890";
    private List<String> skills = Arrays.asList("Python", "SQL", "Apache Airflow", "Azure Synapse", "Scala");
    private String experience = "4+ years in Data Engineering, specializing in cloud platforms (Azure, AWS, Snowflake)";
    private String education = "Masters in Computer Science - University of Louisiana at Lafayette";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Load the HTML template
        InputStream inputStream = getClass().getResourceAsStream("/templates/resume.html");
        if (inputStream == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // Convert the HTML template to a string
        String htmlTemplate = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        // Create a string of <li> elements for the skills
        StringBuilder skillsListBuilder = new StringBuilder();
        for (String skill : skills) {
            skillsListBuilder.append("<li>").append(skill).append("</li>");
        }
        String skillsAsHtml = skillsListBuilder.toString();

        // Replace the placeholders with actual resume data
        String htmlContent = htmlTemplate
                .replace("{{name}}", name != null ? name : "")
                .replace("{{phone}}", phone != null ? phone : "")
                .replace("{{skills}}", skillsAsHtml)  // Insert the skills as <li> elements
                .replace("{{experience}}", experience != null ? experience : "")
                .replace("{{education}}", education != null ? education : "");

        // Serve the HTML content
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(htmlContent);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Update resume details from POST request
        name = request.getParameter("name");
        phone = request.getParameter("phone");
        skills = Arrays.asList(request.getParameter("skills").split(","));
        experience = request.getParameter("experience");
        education = request.getParameter("education");

        // Redirect back to the GET method to display the updated resume
        response.sendRedirect("/resume");
    }
}


