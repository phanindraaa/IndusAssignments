package com.indus.training.core.svc;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import com.indus.training.core.domain.BodyIndexInput;
import com.indus.training.core.domain.BodyIndexOutput;
import com.indus.training.core.impl.BodyIndexByteStream;

import junit.framework.TestCase;

public class testBMIStream extends TestCase {
	private  BodyIndexByteStream BMIObj;
	protected void setUp() throws Exception {
		super.setUp();
		BMIObj = new BodyIndexByteStream();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	  
    public void testBMIStreamBytes() {  
      BodyIndexInput bodyIndexInpObj = new BodyIndexInput();
      BodyIndexOutput bodyIndexOutObj = new BodyIndexOutput();
      bodyIndexInpObj.setFilePath("src/main/resources/");
      bodyIndexInpObj.setFileName("BMIInp.txt");

      bodyIndexOutObj.setFilePath("src/main/resources/");
      bodyIndexOutObj.setFileName("BMIOut.txt");
      try {
          BMIObj.readWeightHeight(bodyIndexInpObj);
          
          String expOutputFile = "BMI is 2.361111111111111";
          BufferedReader line = new BufferedReader(new FileReader(bodyIndexOutObj.getFilePath()+bodyIndexOutObj.getFileName()));
          String actOutputFile = line.readLine();
          
          
          assertEquals(expOutputFile, actOutputFile);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
