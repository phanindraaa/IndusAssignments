package com.indus.training.spring.Serilaization;

import com.indus.training.spring.entity.CalcInput;

public class XMLSerialization {
    public static String serialize(CalcInput input) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xml.append("<clac-input>\n");
        xml.append("  <operand1>").append(input.getOperand1()).append("</operand1>\n");
        xml.append("  <operand2>").append(input.getOperand2()).append("</operand2>\n");
        xml.append("  <operation>").append(input.getOperation()).append("</operation>\n");
        xml.append("</clac-input>");
        return xml.toString();
    }

    public static CalcInput deserialize(String xml) {
        double operand1 = 0;
        double operand2 = 0;
        String operation = "";

        String[] lines = xml.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("<operand1>")) {
                operand1 = Double.parseDouble(line.replace("<operand1>", "").replace("</operand1>", ""));
            } else if (line.startsWith("<operand2>")) {
                operand2 = Double.parseDouble(line.replace("<operand2>", "").replace("</operand2>", ""));
            } else if (line.startsWith("<operation>")) {
                operation = line.replace("<operation>", "").replace("</operation>", "");
            }
        }

        return new CalcInput(operand1, operand2, operation);
    }
}