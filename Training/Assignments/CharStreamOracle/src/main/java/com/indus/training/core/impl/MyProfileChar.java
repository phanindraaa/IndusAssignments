package com.indus.training.core.impl;

import com.indus.training.core.domain.MyProfileInp;
import com.indus.training.core.domain.MyProfileOut;
import com.indus.training.core.svc.IMyProfileChar;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyProfileChar implements IMyProfileChar {

	@Override
	public void MyProfileCharStream(MyProfileInp MyProfileInpObj, MyProfileOut MyProfileOutObj) throws IOException {
		// TODO Auto-generated method stub
		FileReader inputStream = null;
		FileWriter outputStream = null;

		try {
			inputStream = new FileReader(MyProfileInpObj.getFilePath() + MyProfileInpObj.getFileName());
			outputStream = new FileWriter(MyProfileOutObj.getFilePath() + MyProfileOutObj.getFileName());
			int C = 0;
			while (C != -1) {
				C = inputStream.read();
				// System.out.println( C = In.read());
				outputStream.write(C);
				// System.out.print((char) C);
			}
			// System.out.println( C = In.());
		} finally {
			inputStream.close();
			outputStream.close();
			// TODO: handle finally clause
		}
	}
	
	public static void main(String[] args) throws IOException {
		MyProfileInp MyProfileInpObj = new MyProfileInp();
		MyProfileInpObj.setFilePath("src/main/resources/");
		MyProfileInpObj.setFileName("MyProfileInp.txt");
		
		MyProfileOut MyProfileOutObj = new MyProfileOut();
		MyProfileOutObj.setFilePath("src/main/resources/");
		MyProfileOutObj.setFileName("MyProfileOut.txt");
		
		MyProfileChar MyProfileObj = new MyProfileChar();
		MyProfileObj.MyProfileCharStream(MyProfileInpObj, MyProfileOutObj);
		
	}

}
