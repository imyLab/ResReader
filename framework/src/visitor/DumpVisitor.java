package visitor;

import message.Message;
import message.MessageACK;
import message.MessageAuthentification;
import message.MessageDownload;
import message.MessageListOfPics;
import message.MessageStop;
import message.MessageUpload;

public class DumpVisitor implements Visitor {

	@Override
	public void encode(Message m) {

		m.accept(this);
	}

	@Override
	public void encode(MessageAuthentification ma) {
		System.out.println("Encode on MessageAuthentification with user id "
				+ ma.getUId());

	}

	@Override
	public void encode(MessageACK mack) {
		System.out.println("Encode on MessageACK " + mack.getDescription());

	}

	@Override
	public void encode(MessageDownload md) {
		System.out.println("Encode on MessageDownload for pic with UID "
				+ md.getUIdPic());

	}

	@Override
	public void encode(MessageUpload mu) {
		System.out.println("Encode on MessageUpload " + mu.getIdPic());

	}

	@Override
	public void encode(MessageStop ms) {
		System.out.println("Encode on MessageStop");

	}

	@Override
	public void encode(MessageListOfPics ml) {
		System.out.println("Encode on MessageListOfPics " + ml.getListPics());

	}

}