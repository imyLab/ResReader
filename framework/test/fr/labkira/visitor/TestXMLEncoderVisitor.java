package fr.labkira.visitor;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import fr.labkira.message.MessageAuthentification;
import fr.labkira.visitor.XMLEncodoerVisitor;



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
