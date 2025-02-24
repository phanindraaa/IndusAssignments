package com.indus.training.core.impl;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import com.indus.training.core.domain.MyProfileInp;
import com.indus.training.core.domain.MyProfileOut;
import com.indus.training.core.svc.IMyProfile;

public class MyProfile implements IMyProfile {

	@Override
	public void MyProfileStream(MyProfileInp MyProfileInpObj, MyProfileOut MyProfileOutObj) throws IOException {
		// TODO Auto-generated method stub
		FileReader InputStream;
		FileWriter OutputStream;
		BufferedReader BufferInpStream = null;
		BufferedWriter BufferOutStream = null;
		try {
			
			//InputStream = new BufferedReader(MyProfileInpObj.getFilePath()+MyProfileInpObj.getFileName());
//			String Path = MyProfileInpObj.getFilePath() + MyProfileInpObj.getFileName();
			InputStream = new FileReader(MyProfileInpObj.getFilePath() + MyProfileInpObj.getFileName());
			BufferInpStream = new BufferedReader(InputStream);
			
			OutputStream = new FileWriter(MyProfileOutObj.getFilePath() + MyProfileOutObj.getFileName());
			BufferOutStream = new BufferedWriter(OutputStream);
			
			String line;
			while ((line = BufferInpStream.readLine()) != null) {
	                // Write the line to the output file
				BufferOutStream.write(line);
	                // Add a new line after writing each line
				BufferOutStream.newLine();
	            }
			
		} finally {
			// TODO: handle finally clause
			BufferInpStream.close();
			BufferOutStream.close();
		}
	}
	
	
}
