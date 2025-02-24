package com.indus.training.spring.Serilaization;

import com.indus.training.spring.entity.CalcInput;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLSerialization {
    public static String serialize(CalcInput input) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CalcInput.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter writer = new StringWriter();
        marshaller.marshal(input, writer);
        return writer.toString();
    }

    public static CalcInput deserialize(String xml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CalcInput.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader reader = new StringReader(xml);
        return (CalcInput) unmarshaller.unmarshal(reader);
    }
}