package test;

import message.MessageACK;
import message.MessageAuthentification;
import visitor.DumpVisitor;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		DumpVisitor dv = new DumpVisitor();
		MessageAuthentification ma = new MessageAuthentification();
		MessageACK mack = new MessageACK();
		ma.setUId(1004);
		mack.setDescription("Everything s fine");

		dv.encode(mack);
		dv.encode(ma);
		
		//hello hi
	
	}

}