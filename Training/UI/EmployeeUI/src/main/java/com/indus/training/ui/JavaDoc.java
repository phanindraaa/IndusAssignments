package com.indus.training.ui;

import javax.tools.ToolProvider;

public class JavaDoc {
    public static void main(String[] args) {
        // Define the output directory for Javadoc
        String outputDir = "docs";

        // Define the source files or directories containing the Java source code
        String[] javadocArgs = new String[] {
            "-d", outputDir,            // Output directory for the Javadoc
            "src/main/java"             // Directory containing source files
        };

        // Get the system Javadoc tool
        int result = ToolProvider.getSystemDocumentationTool().run(null, null, null, javadocArgs);

        if (result == 0) {
            System.out.println("Javadoc generation succeeded.");
        } else {
            System.err.println("Javadoc generation failed.");
        }
    }
}
