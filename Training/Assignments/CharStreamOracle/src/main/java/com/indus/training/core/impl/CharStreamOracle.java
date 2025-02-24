package com.indus.training.core.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamOracle {
	 public static void main(String[] args) throws IOException {

	        FileReader inputStream = null;
	        FileWriter outputStream = null;

	        try {
	            inputStream = new FileReader("src/main/resources/xanadu.txt");
	            outputStream = new FileWriter("src/main/resources/characteroutput.txt");

	            int c;
	            while ((c = inputStream.read()) != -1) {
	            	System.out.println((char)c);
	                outputStream.write(c);
	            }
	        } finally {
	            if (inputStream != null) {
	                inputStream.close();
	            }
	            if (outputStream != null) {
	                outputStream.close();
	            }
	        }
	    }
}
