package visitor;

import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import message.Message;
import message.MessageACK;
import message.MessageAuthentification;
import message.MessageDownload;
import message.MessageListOfPics;
import message.MessageStop;
import message.MessageUpload;

public class XMLEncodoerVisitor implements Visitor {

	public static final String MESSAGE_TYPE_ATTRIBUTE = "type";

	private Document xmlDoc = null;
	private Element rootElement;
	private DocumentBuilder docBuilder;

	public XMLEncodoerVisitor() throws ParserConfigurationException {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		this.docBuilder = docFactory.newDocumentBuilder();

		this.newSession();
	}

	/**
	 * Prepares this {@link Visitor} for a new visit session by deleting
	 * previous XML document.
	 */
	protected void newSession() {

		this.xmlDoc = this.docBuilder.newDocument();
		this.rootElement = this.xmlDoc.createElement("message");
		this.xmlDoc.appendChild(this.rootElement);
	}

	public void writeDocTo(OutputStream os) throws TransformerException {

		if (this.xmlDoc == null)
			return;

		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(this.xmlDoc);
		StreamResult result = new StreamResult(os);

		transformer.transform(source, result);
	}

	@Override
	public void encode(Message m) {
		this.newSession();
		m.accept(this);
	}

	@Override
	public void encode(MessageAuthentification ma) {
		this.rootElement.setAttribute(MESSAGE_TYPE_ATTRIBUTE,
				MessageAuthentification.class.getName());

		Element uuid = this.xmlDoc.createElement("uuid");
		uuid.appendChild(this.xmlDoc.createTextNode(ma.getUId().toString()));

		// Password ??
		Element psswd = this.xmlDoc.createElement("password");
		psswd.appendChild(this.xmlDoc.createTextNode("password here"));

		this.rootElement.appendChild(uuid);

	}

	@Override
	public void encode(MessageACK mack) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("needs implementation");
	}

	@Override
	public void encode(MessageDownload md) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("needs implementation");
	}

	@Override
	public void encode(MessageUpload mu) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("needs implementation");
	}

	@Override
	public void encode(MessageStop ms) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("needs implementation");
	}

	@Override
	public void encode(MessageListOfPics ml) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("needs implementation");
	}

}
