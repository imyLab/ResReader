package fr.labkira.visitor;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.labkira.message.Message;
import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageACK.MessageType;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.message.MessageDownload;
import fr.labkira.message.MessageListOfPics;
import fr.labkira.message.MessageStop;
import fr.labkira.message.MessageUpload;



public class XmlDecoder {
	
	private Element rootElement;
	private DocumentBuilder docBuilder;

	
	public Message decode(String xmlM) throws SAXException, IOException {
		
		Message m = null;
		String node= this.rootElement.getAttributeNode("message type").toString();
		
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
	
		return m;
	}

	public MessageAuthentification decodeMessageAuthentification(String xmlMa) throws SAXException, IOException {
		Document d = this.docBuilder.parse(new ByteArrayInputStream(xmlMa.getBytes()));
		this.rootElement = (Element) d.getElementsByTagName(MessageACK.class.getName());	
		
		UUID uuid = java.util.UUID.fromString(this.rootElement.getAttribute("uuid"));
		String  password = this.rootElement.getAttribute("password");
		String username = this.rootElement.getAttribute("userName");
		
		return new MessageAuthentification(uuid, password, username);
	}

	public MessageACK decodeMessageACK(String xmlMack) throws SAXException, IOException {
		
		Document d = this.docBuilder.parse(new ByteArrayInputStream(xmlMack.getBytes()));
		this.rootElement = (Element) d.getElementsByTagName(MessageACK.class.getName());
		
		
		String  type = this.rootElement.getAttribute("type");
		String description = this.rootElement.getAttribute("descrption");
		
		return new MessageACK(MessageType.valueOf(type),description);
	}

	public MessageDownload decodeMessageDownload(String xmlMd) throws SAXException {
		MessageDownload md = null;
		try {
			Document d = this.docBuilder.parse(new ByteArrayInputStream(xmlMd.getBytes()));
			this.rootElement = (Element) d.getElementsByTagName(MessageDownload.class.getName());
			byte[] bytes = Base64.decodeBase64(this.rootElement.getAttribute("image"));
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
			
			UUID uuid = java.util.UUID.fromString(this.rootElement.getAttribute("uuid"));
			md.setUIdPic(uuid);
			md.setFile(new File(image.toString()));
			//md.setImg(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return md;
	}

	public MessageUpload decodeMessageUploadload(String xmlMu) {
		return null;
	}

	public MessageStop decodeMessageStop(String xmlMs) {
			
		return new MessageStop();
	}

	public MessageListOfPics decodeMessageListOfPics(String xmlMl) {
		
		
		return new MessageListOfPics();
	}

}
