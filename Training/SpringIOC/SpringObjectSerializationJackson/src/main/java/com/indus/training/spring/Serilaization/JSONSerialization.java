package com.indus.training.spring.Serilaization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.indus.training.spring.entity.CalcInput;

public class JSONSerialization {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String serialize(CalcInput input) throws JsonProcessingException {
        return objectMapper.writeValueAsString(input);
    }

    public static CalcInput deserialize(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, CalcInput.class);
    }

}