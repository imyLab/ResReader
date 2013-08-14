package fr.labkira.visitor;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Element;

import fr.labkira.message.Message;
import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.message.MessageDownload;
import fr.labkira.message.MessageListOfPics;
import fr.labkira.message.MessageStop;
import fr.labkira.message.MessageUpload;

// Je suis dsl mais je ne peux pas trop.

public class XmlDecoder {
	private Element rootElement;
	private MessageDownload md;

	public Message decode(String xmlM) {

		return null;
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
			md.setImg(image);
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
		return null;
	}

	public MessageListOfPics decodeMessageListOfPics(String xmlMl) {
		return null;
	}

}
