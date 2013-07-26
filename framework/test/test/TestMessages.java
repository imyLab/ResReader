package test;

import java.util.UUID;

import message.MessageACK;
import message.MessageAuthentification;
import visitor.DumpVisitor;

public class TestMessages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DumpVisitor dv = new DumpVisitor();
		MessageAuthentification ma = new MessageAuthentification();
		MessageACK mack = new MessageACK();
		ma.setUId(UUID.randomUUID());
		mack.setDescription("Everything s fine");

		dv.encode(mack);
		dv.encode(ma);

		// hello hi

	}

}