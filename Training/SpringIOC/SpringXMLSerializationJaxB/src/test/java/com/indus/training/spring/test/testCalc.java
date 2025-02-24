package com.indus.training.spring.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.indus.training.spring.Serilaization.JSONSerialization;
import com.indus.training.spring.Serilaization.XMLSerialization;
import com.indus.training.spring.entity.CalcInput;

public class testCalc {

    @Test
    public void testXmlSerialization() throws Exception {
    	CalcInput input = new CalcInput(5.0, 3.0, "add");
        String xml = XMLSerialization.serialize(input);

        assertTrue(xml.contains("<operand1>5.0</operand1>"));
        assertTrue(xml.contains("<operand2>3.0</operand2>"));
        assertTrue(xml.contains("<operation>add</operation>"));
    }

    @Test
    public void testJsonSerialization() {
    	CalcInput input = new CalcInput(5.0, 3.0, "add");
        String json = JSONSerialization.serialize(input);

        assertTrue(json.contains("\"operand1\":5.0"));
        assertTrue(json.contains("\"operand2\":3.0"));
        assertTrue(json.contains("\"operation\":\"add\""));
    }

  

  

    @Test
    public void testJsonDeSerialization() {
    	CalcInput input = new CalcInput(5.0, 3.0, "add");
        String json = JSONSerialization.serialize(input);
        CalcInput deserialized = JSONSerialization.deserialize(json);

        assertEquals(input.getOperand1(), deserialized.getOperand1(), 0.001);
        assertEquals(input.getOperand2(), deserialized.getOperand2(), 0.001);
        assertEquals(input.getOperation(), deserialized.getOperation());
    }
    @Test
    public void testXMLDeserialization() throws Exception {
    	CalcInput input1 = new CalcInput(Double.MAX_VALUE, Double.MIN_VALUE, "divide");
    	CalcInput input2 = new CalcInput(0.0, 0.0, "");

        String xml1 = XMLSerialization.serialize(input1);
        String xml2 = XMLSerialization.serialize(input2);

        CalcInput deserialized1 = XMLSerialization.deserialize(xml1);
        CalcInput deserialized2 = XMLSerialization.deserialize(xml2);

        assertEquals(input1.getOperand1(), deserialized1.getOperand1(), 0.001);
        assertEquals(input1.getOperand2(), deserialized1.getOperand2(), 0.001);
        assertEquals(input1.getOperation(), deserialized1.getOperation());

        assertEquals(input2.getOperand1(), deserialized2.getOperand1(), 0.001);
        assertEquals(input2.getOperand2(), deserialized2.getOperand2(), 0.001);
        assertEquals(input2.getOperation(), deserialized2.getOperation());
    }

   
}