package test;

import visitor.DumpVisitor;
import message.Message.MessageType;
import message.MessageACK;
import message.MessageAuthentification;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		DumpVisitor dv = new DumpVisitor();
		MessageAuthentification ma = new MessageAuthentification();
		MessageACK mack = new MessageACK();
		ma.setUId(1004);
		mack.setDescription(" Tout va bien ");
		mack.setType(MessageType.Ok);
		dv.setMa(ma);
		dv.setMack(mack);
		dv.encode(ma);
		dv.encode(mack);
		dv.decodeMessageACK();
		dv.decodeMessageAuthentification();
		//hello hi
		
	}

}