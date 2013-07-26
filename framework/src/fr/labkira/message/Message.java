package fr.labkira.message;

import fr.labkira.visitor.Visitor;

public abstract class Message {



	public void accept(Visitor visitor) {

			visitor.encode(this);

	}
}
