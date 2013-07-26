package test;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import visitor.XMLEncodoerVisitor;

import message.MessageAuthentification;

public class TestXMLEncoderVisitor {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {

		MessageAuthentification msg = new MessageAuthentification();
		msg.setUId(UUID.randomUUID());

		XMLEncodoerVisitor encoder = new XMLEncodoerVisitor();

		encoder.encode(msg);

		ByteArrayOutputStream s = new ByteArrayOutputStream();

		encoder.writeDocTo(s);
		
		String content = s.toString();

		System.out.println(content);

	}
}
