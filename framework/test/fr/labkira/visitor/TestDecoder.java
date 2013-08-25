package fr.labkira.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import fr.labkira.message.Message;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.message.MessageDownload;

public class TestDecoder {
	
	@Test
	public void test_DecodeMessageAuthentication() throws TransformerException, ParserConfigurationException, SAXException, IOException {

		MessageAuthentification msg = new MessageAuthentification();
		UUID id = UUID.randomUUID();
		
		msg.setUId(id);
		msg.setPassword("imyLab02");
		
		
		assertEquals(id, msg.getUId());
		assertEquals("imyLab02", msg.getPassword());

		XMLEncoderVisitor encoder = new XMLEncoderVisitor();
		encoder.encode(msg);

		ByteArrayOutputStream s = new ByteArrayOutputStream();
		encoder.writeDocTo(s);
		String content = s.toString();
		
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		//create document from string xml :
		Document doc = docBuilder.parse(new ByteArrayInputStream(content.getBytes()));

		assertNotNull(doc);
		
		//get element called by tag name. There is only 1 called message in the document, so we want the 1st and sole from the NodeList
		Node message = doc.getElementsByTagName("message").item(0);
		assertNotNull(message);
		
		//Accessing attributes from the node <message>. There is only 1 called type.
		Node attribute = message.getAttributes().item(0);
		assertNotNull(attribute);
		
		//And here we got what we want :
		
		assertEquals("fr.labkira.message.MessageAuthentification", attribute.getTextContent());
		System.out.println(message.getTextContent());
	}
	
	@Test
	public void test_DecodeMessageDownload() throws TransformerException, ParserConfigurationException, SAXException, IOException {

		MessageDownload md = new MessageDownload();

		File file = new File ("image.jpeg");
		UUID id = UUID.randomUUID();
		
		md.setFile(file);
		md.setUIdPic(id);
		
		XMLEncoderVisitor encoder = new XMLEncoderVisitor();
		encoder.encode(md);

		ByteArrayOutputStream s = new ByteArrayOutputStream();
		encoder.writeDocTo(s);
		String content = s.toString();
		
		assertNotNull(s);
				
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		//create document from string xml :
		Document doc = docBuilder.parse(new ByteArrayInputStream(content.getBytes()));

		assertNotNull(doc);
		
		//get element called by tag name. There is only 1 called message in the document, so we want the 1st and sole from the NodeList
		Node message = doc.getElementsByTagName("message").item(0);
		assertNotNull(message);
		
		//Accessing attributes from the node <message>. There is only 1 called type.
		Node attribute = message.getAttributes().item(0);
		assertNotNull(attribute);
		
		//And here we got what we want :
		
		assertEquals("fr.labkira.message.MessageDownload", attribute.getTextContent());
		System.out.println(message.getTextContent());
	}
	
	
}
