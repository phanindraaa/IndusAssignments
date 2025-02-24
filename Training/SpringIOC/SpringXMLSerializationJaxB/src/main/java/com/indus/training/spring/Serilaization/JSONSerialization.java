package com.indus.training.spring.Serilaization;

import java.util.HashMap;
import java.util.Map;

import com.indus.training.spring.entity.CalcInput;

public class JSONSerialization {
    public static String serialize(CalcInput input) {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("operand1", input.getOperand1());
        jsonMap.put("operand2", input.getOperand2());
        jsonMap.put("operation", input.getOperation());

        StringBuilder json = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":");
            if (entry.getValue() instanceof String) {
                json.append("\"").append(entry.getValue()).append("\"");
            } else {
                json.append(entry.getValue());
            }
            json.append(",");
        }
        json.setLength(json.length() - 1);
        json.append("}");

        return json.toString();
    }

    public static CalcInput deserialize(String json) {
        json = json.replaceAll("[{}\"]", "");
        String[] pairs = json.split(",");
        Map<String, String> jsonMap = new HashMap<>();

        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            jsonMap.put(keyValue[0].trim(), keyValue[1].trim());
        }

        double operand1 = Double.parseDouble(jsonMap.get("operand1"));
        double operand2 = Double.parseDouble(jsonMap.get("operand2"));
        String operation = jsonMap.get("operation");

        return new CalcInput(operand1, operand2, operation);
    }
}