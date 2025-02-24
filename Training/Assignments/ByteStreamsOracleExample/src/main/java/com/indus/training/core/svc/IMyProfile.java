package com.indus.training.core.svc;

import java.io.IOException;

import com.indus.training.core.domain.MyProfileInput;
import com.indus.training.core.domain.MyProfileOutput;

public interface IMyProfile {

	public void ByteFileStream(MyProfileOutput OutObj, MyProfileInput InpObj) throws IOException;
}
