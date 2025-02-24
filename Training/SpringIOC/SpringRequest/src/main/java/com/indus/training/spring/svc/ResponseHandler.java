package com.indus.training.spring.svc;

import com.indus.training.spring.entity.Request;
import java.io.IOException;

public interface ResponseHandler {
    void generateResponse(Request request, String outputFile) throws IOException;
}
