package fr.labkira.visitor;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import junit.framework.TestFailure;

import org.junit.Test;

import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageACK.MessageType;

public class XMLEncoderVisitor_UT {

	@Test
	public void test_MessageACK() throws TransformerException, ParserConfigurationException {
		MessageACK mack = new MessageACK();
		mack.setDescription("Everything is alright");
		mack.setType(MessageType.Ok);
		
		assertEquals(MessageType.Ok, mack.getType());
		assertEquals("Everything is alright", mack.getDescription());
		
		
		XMLEncodoerVisitor encoder = new XMLEncodoerVisitor();
		encoder.encode(mack);
		
		ByteArrayOutputStream s = new ByteArrayOutputStream();
		encoder.writeDocTo(s);
		String content = s.toString();
		
		assertNotNull(s);
		
		//print out the content for visual test...
		System.out.println(content);
	}

	@Test
	public void test_MessageAuthentication() throws TransformerException, ParserConfigurationException {
		
		fail("MessageAuthentication not yet tested");
	}
	
	@Test
	public void test_MessageDownload() throws TransformerException, ParserConfigurationException {
		
		fail("MessageDownload not yet tested");
	}
	
	@Test
	public void test_MessageListOfPics() throws TransformerException, ParserConfigurationException {
		
		fail("MessageListOfPics not yet tested");
	}
	
	//... need more test method as necessary...
}
