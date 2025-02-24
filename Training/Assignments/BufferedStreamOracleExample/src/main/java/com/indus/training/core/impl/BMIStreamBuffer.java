package com.indus.training.core.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.indus.training.core.domain.BMIInput;
import com.indus.training.core.domain.BMIOutput;
import com.indus.training.core.svc.IBMIStream;

public class BMIStreamBuffer implements IBMIStream {

	@Override
	public void BMIStream(BMIInput BMIInpObj, BMIOutput BMIOutObj) throws IOException {
		// TODO Auto-generated method stub
		FileReader InputStream;
		FileWriter OutputStream;
		BufferedReader BufferInpStream = null;
		BufferedWriter BufferOutStream = null;
		try {
			
			//		InputStream = new BufferedReader(MyProfileInpObj.getFilePath()+MyProfileInpObj.getFileName());
//			String path = BMIInpObj.getFilePath() + BMIInpObj.getFileName();
			InputStream = new FileReader(BMIInpObj.getFilePath() + BMIInpObj.getFileName());
			BufferInpStream = new BufferedReader(InputStream);
			
			OutputStream = new FileWriter(BMIOutObj.getFilePath() + BMIOutObj.getFileName());
			BufferOutStream = new BufferedWriter(OutputStream);
			
			String Line;
			double Height = 0.0;
			double Weight = 0.0;
			while ((Line = BufferInpStream.readLine()) != null) {
				 if (Line.startsWith("Height")) {
	                    Height = Double.parseDouble(Line.split("=")[1].trim().replace("\"", "").replace(",", ""));
	                } else if (Line.startsWith("Weight")) {
	                    Weight = Integer.parseInt(Line.split("=")[1].trim().replace("\"", "").replace(".", ""));
	                }
	            }
			 if ((Height != 0.0) && (Weight != 0.0)){
		        	double BMI = Weight / (Height * Height);
		        	BufferOutStream.write(("BMI is "+Double.toString(BMI)).toCharArray());
		        }
		        else {
		        	BufferOutStream.write(("error in calc BMI").toCharArray());
		        }
			
			
		} finally {
			// TODO: handle finally clause
			BufferInpStream.close();
			BufferOutStream.close();
		}
	}

}
