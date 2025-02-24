package ResumeServelet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
    private String name = "Venkata Sai Ginjupalli"; // Default name
    private String education = "Masters in Computer Science"; // Default education
    private String experience = "4+ years in Data Engineering"; // Default experience
    private String skills = "Java, Python, SQL, Apache Airflow"; // Default skills

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Load HTML template from file system
        String htmlFilePath = getServletContext().getRealPath("/WEB-INF/resume.html");
        StringBuilder htmlContent = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(htmlFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                htmlContent.append(line);
            }
        }

        // Replace placeholders with dynamic data
        String finalHtml = htmlContent.toString()
            .replace("{{name}}", name)
            .replace("{{education}}", education)
            .replace("{{experience}}", experience)
            .replace("{{skills}}", skills);

        // Output final HTML
        out.println(finalHtml);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Update resume details from POST request
        name = request.getParameter("name");
        education = request.getParameter("education");
        experience = request.getParameter("experience");
        skills = request.getParameter("skills");

        // Redirect back to the GET method to display updated resume
        response.sendRedirect("simple");
    }
}
