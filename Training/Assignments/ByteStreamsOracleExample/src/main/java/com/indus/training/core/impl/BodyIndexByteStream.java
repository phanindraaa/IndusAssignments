package com.indus.training.core.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.indus.training.core.domain.BodyIndexInput;
import com.indus.training.core.domain.BodyIndexOutput;
import com.indus.training.core.svc.IBMIByteStream;

public class BodyIndexByteStream implements IBMIByteStream {

    FileInputStream in = null;
    FileOutputStream out = null;

    @Override
    public BodyIndexOutput readWeightHeight(BodyIndexInput bodyIndexInpObj)  throws IOException {
        in = new FileInputStream(bodyIndexInpObj.getFilePath() + bodyIndexInpObj.getFileName());
//        

        StringBuilder lineBuilder = new StringBuilder();
        int c;

        Double height = null;
        Integer weight = null;

        while ((c = in.read()) != -1) {
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
        
        BodyIndexOutput bodyIndexOutObj = new BodyIndexOutput();
        bodyIndexOutObj.setHeight(height);
        bodyIndexOutObj.setWeight(weight); 

        in.close();
		return bodyIndexOutObj;
    }


        
        		
       public void writeBodyMassIndex(BodyIndexOutput bodyIndexOutObj) throws IOException {
    	   double height = bodyIndexOutObj.getHeight();
    	   double weight = bodyIndexOutObj.getWeight();
    	   out = new FileOutputStream(bodyIndexOutObj.getFilePath() + bodyIndexOutObj.getFileName());
        if ((height != 0.0) && (weight != 0.0)){
        	double bodyIndex = weight / (height * height);
        	out.write(("bodyIndex is "+Double.toString(bodyIndex)).getBytes());
        }
        else {
        	out.write(("error in calc bodyIndex").getBytes());
        }
       }
       


    public static void main(String[] args) {
    	BodyIndexByteStream bodyIndexObj = new BodyIndexByteStream();
        BodyIndexInput bodyIndexInpObj = new BodyIndexInput();
        
        bodyIndexInpObj.setFilePath("src/main/resources/");
        bodyIndexInpObj.setFileName("bodyIndexInp.txt");

      
        try {
        	 BodyIndexOutput bodyIndexOutObj = bodyIndexObj.readWeightHeight(bodyIndexInpObj);
        	 bodyIndexOutObj.setFilePath("src/main/resources/");
             bodyIndexOutObj.setFileName("bodyIndexOut.txt");
             bodyIndexObj.writeBodyMassIndex(bodyIndexOutObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
