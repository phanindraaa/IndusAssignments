package com.indus.training.spring.svc;

import com.indus.training.spring.entity.Request;

import java.io.IOException;

public interface RequestHandler {
    Request parseRequest(String inputFile) throws IOException;
}
