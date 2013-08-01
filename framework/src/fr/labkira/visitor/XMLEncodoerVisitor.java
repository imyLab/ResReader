package fr.labkira.visitor;

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

import fr.labkira.message.Message;
import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.message.MessageDownload;
import fr.labkira.message.MessageListOfPics;
import fr.labkira.message.MessageStop;
import fr.labkira.message.MessageUpload;

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

	/**
	 * This method write the content of {@link #xmlDoc} in the specified
	 * {@link OutputStream} os
	 * 
	 * @param os
	 *            the {@link OutputStream} to put the content
	 * @throws TransformerException
	 */
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

		
		Element psswd = this.xmlDoc.createElement("password");
		psswd.appendChild(this.xmlDoc.createTextNode(ma.getPassword()));

		this.rootElement.appendChild(uuid);
		this.rootElement.appendChild(psswd);


	}

	@Override
	public void encode(MessageACK mack) {
		this.rootElement.setAttribute(MESSAGE_TYPE_ATTRIBUTE,
				MessageACK.class.getName());

		Element type = this.xmlDoc.createElement("type");
		type.appendChild(this.xmlDoc.createTextNode(mack.getType().toString()));

		
		Element description = this.xmlDoc.createElement("description");
		description.appendChild(this.xmlDoc.createTextNode(mack.getDescription()));

		this.rootElement.appendChild(type);
		this.rootElement.appendChild(description);
	}

	@Override
	public void encode(MessageDownload md) {
		this.rootElement.setAttribute(MESSAGE_TYPE_ATTRIBUTE,
				MessageDownload.class.getName());

		Element uuid = this.xmlDoc.createElement("uuid");
		uuid.appendChild(this.xmlDoc.createTextNode(md.getUIdPic().toString()));

		
		Element img = this.xmlDoc.createElement("image");
		img.appendChild(this.xmlDoc.createTextNode(md.getImg().toString()));

		this.rootElement.appendChild(uuid);
		this.rootElement.appendChild(img);
	}

	@Override
	public void encode(MessageUpload mu) {
		this.rootElement.setAttribute(MESSAGE_TYPE_ATTRIBUTE,
				MessageUpload.class.getName());

		Element uuid = this.xmlDoc.createElement("uuid");
		uuid.appendChild(this.xmlDoc.createTextNode(mu.getIdPic().toString()));

		
		Element img = this.xmlDoc.createElement("image");
		img.appendChild(this.xmlDoc.createTextNode(mu.getImg().toString()));

		this.rootElement.appendChild(uuid);
		this.rootElement.appendChild(img);
	}

	@Override
	public void encode(MessageStop ms) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("needs implementation");
	}

	@Override
	public void encode(MessageListOfPics ml) {
			this.rootElement.setAttribute(MESSAGE_TYPE_ATTRIBUTE,
				MessageDownload.class.getName());

		Element list = this.xmlDoc.createElement("list");
		list.appendChild(this.xmlDoc.createTextNode(ml.getListPics().toString()));


		this.rootElement.appendChild(list);
		
	}

}
