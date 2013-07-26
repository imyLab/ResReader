package fr.labkira.visitor;

import java.util.UUID;

import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.visitor.DumpVisitor;


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