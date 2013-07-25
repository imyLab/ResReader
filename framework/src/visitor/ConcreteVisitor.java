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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void encode(MessageAuthentification ma) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void encode(MessageACK mack) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void encode(MessageDownload md) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void encode(MessageUpload mu) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void encode(MessageStop ms) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void encode(MessageListOfPics ml) {
		// TODO Auto-generated method stub
		
	}


}
