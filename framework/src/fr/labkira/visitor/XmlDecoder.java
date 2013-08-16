package fr.labkira.visitor;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import fr.labkira.message.Message;
import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.message.MessageDownload;
import fr.labkira.message.MessageListOfPics;
import fr.labkira.message.MessageStop;
import fr.labkira.message.MessageUpload;



public class XmlDecoder {
	
	private Element rootElement;
	private Document xmlDoc;
	private DocumentBuilder docBuilder;
	private String xmlMessage;


	public XmlDecoder() throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		this.docBuilder = docFactory.newDocumentBuilder();

		this.newSession();
	}


	protected void newSession() throws SAXException, IOException {

		this.xmlDoc = this.docBuilder.parse(xmlMessage);
		this.rootElement = this.xmlDoc.getDocumentElement();
		
	}

	
	
	
	public void readFromDoc(InputStream is) throws TransformerException, Exception {
		
		
		InputStream input = new ByteArrayInputStream( xmlMessage.getBytes( new String() ) );
	
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		StreamSource source = new StreamSource(input);
		DOMResult result = new DOMResult(xmlDoc);

		transformer.transform(source, result);
	}
	
	
	public Message decode(String xmlM) {
		Message m = null;
		String node= xmlDoc.getFirstChild().toString();
		if(node.equals("message type")){
			switch (node) {
			case "fr.labkira.message.MessageUpload":
				m = this.decodeMessageUploadload(xmlM);
				break;
			case "fr.labkira.message.MessageDownload":
				m = this.decodeMessageDownload(xmlM);
				break;
				
			case "fr.labkira.message.MessageListOfPics":
				m = this.decodeMessageListOfPics(xmlM);
				break;
				
			case "fr.labkira.message.MessageStop":
				m = this.decodeMessageStop(xmlM);
				break;
				
			case "fr.labkira.message.MessageACK":
				m = this.decodeMessageACK(xmlM);
				break;
				
			case "fr.labkira.message.MessageAuthentification":
				m = this.decodeMessageAuthentification(xmlM);
				break;

			default:
				m = this.decode(xmlM);
				break;
			}
		}
		return m;
	}

	public MessageAuthentification decodeMessageAuthentification(String xmlMa) {
		
		
		return null;
	}

	public MessageACK decodeMessageACK(String xmlMack) {

		return null;
	}

	public MessageDownload decodeMessageDownload(String xmlMd) {

		try {
			xmlMd = rootElement.getTextContent();
			byte[] bytes = Base64.decodeBase64(xmlMd);
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
			//md.setImg(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public MessageUpload decodeMessageUploadload(String xmlMu) {
		return null;
	}

	public MessageStop decodeMessageStop(String xmlMs) {
		return null;
	}

	public MessageListOfPics decodeMessageListOfPics(String xmlMl) {
		return null;
	}

}
