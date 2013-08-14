package fr.labkira.visitor;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import junit.framework.TestFailure;

import org.junit.Test;

import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.message.MessageACK.MessageType;
import fr.labkira.message.MessageDownload;
import fr.labkira.message.MessageListOfPics;
import fr.labkira.message.MessageStop;

public class XMLEncoderVisitor_UT {

	@Test
	public void test_MessageACK() throws TransformerException, ParserConfigurationException {
		MessageACK mack = new MessageACK();
		mack.setDescription("Everything is alright");
		mack.setType(MessageType.Ok);
		
		assertEquals(MessageType.Ok, mack.getType());
		assertEquals("Everything is alright", mack.getDescription());
		
		
		XMLEncoderVisitor encoder = new XMLEncoderVisitor();
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
		
		assertNotNull(s);
			
		System.out.println(content); 
	}
	
	@Test
	public void test_MessageDownload() throws TransformerException, ParserConfigurationException, IOException {
		
		File file = new File ("image(1).jpeg");
		BufferedImage img = ImageIO.read(file);
		MessageDownload md = new MessageDownload(img);
		UUID id = UUID.randomUUID();
		md.setUIdPic(id);
		
		
		
		assertEquals(id, md.getUIdPic());
		assertEquals(img, md.getImg());

		XMLEncoderVisitor encoder = new XMLEncoderVisitor();
		encoder.encode(md);

		ByteArrayOutputStream s = new ByteArrayOutputStream();
		encoder.writeDocTo(s);
		String content = s.toString();
		
		assertNotNull(s);
			
		System.out.println(content);
	}
	
	@Test
	public void test_MessageListOfPics() throws TransformerException, ParserConfigurationException {
		
		MessageListOfPics ml = new MessageListOfPics();
		UUID id = UUID.randomUUID();
		ml.setListPics(id, "new pic");
		
		assertEquals("new pic", ml.getListPics().get(id));

		XMLEncoderVisitor encoder = new XMLEncoderVisitor();
		encoder.encode(ml);

		ByteArrayOutputStream s = new ByteArrayOutputStream();
		encoder.writeDocTo(s);
		String content = s.toString();
		
		assertNotNull(s);
			
		System.out.println(content); 
	}
	@Test
	public void test_MessageStop() throws TransformerException, ParserConfigurationException {
		
		MessageStop ms = new MessageStop();
		
		XMLEncoderVisitor encoder = new XMLEncoderVisitor();
		encoder.encode(ms);

		ByteArrayOutputStream s = new ByteArrayOutputStream();
		encoder.writeDocTo(s);
		String content = s.toString();
		
		assertNotNull(s);
			
		System.out.println(content); 
	}

}
