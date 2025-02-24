package com.indus.training.core.impl;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

import com.indus.training.core.domain.BMIInput;
import com.indus.training.core.domain.BMIOutput;
import com.indus.training.core.svc.IBMIStreamChar;

public class BMIStreamChar implements IBMIStreamChar {

	@Override
	public void BMIStream(BMIInput BMIInpObj, BMIOutput BMIOutObj) throws IOException {
		// TODO Auto-generated method stub
		FileReader inputStream = null;
		FileWriter outputStream = null;
		try {
			inputStream = new FileReader(BMIInpObj.getFilePath() + BMIInpObj.getFileName());
			outputStream = new FileWriter(BMIOutObj.getFilePath() + BMIOutObj.getFileName());
		
		StringBuilder lineBuilder = new StringBuilder();
        int c;

        Double height = null;
        Integer weight = null;

        while ((c = inputStream.read()) != -1) {
            char character = (char) c;
            System.out.println(character);
            
            if(character == '.') {
            	System.out.println("last");
            }

            // Check if the character is a newline
            if (character == '\n' || character == '\r') {
                String line = lineBuilder.toString().trim();

                // Process the line to extract height and weight
                if (line.startsWith("Height")) {
                    height = Double.parseDouble(line.split("=")[1].trim().replace("\"", "").replace(",", ""));
                } else if (line.startsWith("Weight")) {
                    weight = Integer.parseInt(line.split("=")[1].trim().replace("\"", "").replace(".", ""));
                }

                // Clear the lineBuilder for the next line
                lineBuilder.setLength(0);
                
            } else {
                // Accumulate characters in the lineBuilder
                lineBuilder.append(character);
            }
        }
        
        if (lineBuilder.length() > 0) {
        	 String line = lineBuilder.toString().trim();
        	 if (line.startsWith("Height")) {
                 height = Double.parseDouble(line.split("=")[1].trim().replace("\"", "").replace(",", ""));
             } else if (line.startsWith("Weight")) {
                 weight = Integer.parseInt(line.split("=")[1].trim().replace("\"", "").replace(".", ""));
             }
        }
        
        if ((height != null) && (weight != null)){
        	double BMI = weight / (height * height);
        	outputStream.write(("BMI is "+Double.toString(BMI)).toCharArray());
        }
        else {
        	outputStream.write(("error in calc BMI").toCharArray());
        }
        
		} finally {
			// TODO: handle finally clause
			inputStream.close();
			outputStream.close();
		}
			
		

	}
	
	public static void main(String[] args) {
		BMIStreamChar BMIObj = new BMIStreamChar();
        BMIInput BMIInpObj = new BMIInput();
        BMIOutput BMIOutObj = new BMIOutput();
        BMIInpObj.setFilePath("src/main/resources/");
        BMIInpObj.setFileName("BMIInp.txt");

        BMIOutObj.setFilePath("src/main/resources/");
        BMIOutObj.setFileName("BMIOut.txt");
        try {
            BMIObj.BMIStream(BMIInpObj, BMIOutObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
