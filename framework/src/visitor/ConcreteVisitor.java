package visitor;

import java.io.OutputStream;

import org.omg.CORBA.portable.InputStream;

import message.Message;
import message.MessageACK;
import message.MessageAuthentification;
import message.MessageDownload;
import message.MessageListOfPics;
import message.MessageStop;
import message.MessageUpload;

public class ConcreteVisitor implements Visitor {
	
	InputStream input;
	OutputStream output;

	@Override
	public void encode(Message m) {
		m.accept(this, Visitor.RequestType.Encode);

	}

	@Override
	public void encode(MessageAuthentification ma) {

		ma.accept(this, Visitor.RequestType.Encode);

	}

	@Override
	public void encode(MessageACK mack) {
		// TODO Auto-generated method stub
		mack.accept(this, Visitor.RequestType.Encode);
	}

	@Override
	public void encode(MessageDownload md) {
		
		md.accept(this, Visitor.RequestType.Encode);
		
	}

	@Override
	public void encode(MessageUpload mu) {
		// TODO Auto-generated method stub
		mu.accept(this, Visitor.RequestType.Encode);
	}

	@Override
	public void encode(MessageStop ms) {
		// TODO Auto-generated method stub
		ms.accept(this, Visitor.RequestType.Encode);
	}

	@Override
	public void encode(MessageListOfPics ml) {
		// TODO Auto-generated method stub
		ml.accept(this, Visitor.RequestType.Encode);
	}

	@Override
	public void decode(Message m) {
		m.accept(this, Visitor.RequestType.Decode);
	}

	@Override
	public MessageAuthentification decodeMessageAuthentification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageACK decodeMessageACK() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageDownload decodeMessageDownload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageUpload decodeMessageUpload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageStop decodeMessageStop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageListOfPics decodeMessageListOfPics() {
		// TODO Auto-generated method stub
		return null;
	}

}
