package com.indus.training.core.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.indus.training.core.domain.MyProfileInput;
import com.indus.training.core.domain.MyProfileOutput;
import com.indus.training.core.svc.IMyProfile;

public class ByteStreamMyProfile implements IMyProfile{
	FileInputStream In = null;
	FileOutputStream Out = null;
	
	@Override
	public void ByteFileStream(MyProfileOutput OutObj, MyProfileInput InpObj) throws IOException {
	
	try {
		In = new FileInputStream(InpObj.getFilePath() + InpObj.getFileName());
		Out = new FileOutputStream(OutObj.getFilePath() + OutObj.getFileName());
		int C = 0;
		while (C != -1) {
			C = In.read();
			//		System.out.println( C = In.read());	
			Out.write(C);
			//		System.out.print((char) C);
		}
		//	System.out.println( C = In.());
	} finally {
		In.close();
		Out.close();
		// TODO: handle finally clause
	}
	
	
	}
	
	public static void main(String[] args) throws IOException {
		MyProfileInput MyProfileInpObj = new MyProfileInput();
		MyProfileInpObj.setFilePath("src/main/resources/");
		MyProfileInpObj.setFileName("MyProfileInp.txt");
		
		MyProfileOutput MyProfileOutObj = new MyProfileOutput();
		MyProfileOutObj.setFilePath("src/main/resources/");
		MyProfileOutObj.setFileName("MyProfileOut.txt");
		
		ByteStreamMyProfile MyProfileObj = new ByteStreamMyProfile();
		MyProfileObj.ByteFileStream(MyProfileOutObj, MyProfileInpObj);
		
	}
}
