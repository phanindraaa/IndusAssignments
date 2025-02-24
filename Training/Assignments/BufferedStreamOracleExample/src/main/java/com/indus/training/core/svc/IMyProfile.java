package com.indus.training.core.svc;

import java.io.IOException;

import com.indus.training.core.domain.MyProfileInp;
import com.indus.training.core.domain.MyProfileOut;

public interface IMyProfile {
	public void MyProfileStream(MyProfileInp MyProfileInpObj, MyProfileOut MyProfileOutObj) throws IOException;
}
