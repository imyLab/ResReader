package fr.labkira.message;

import fr.labkira.visitor.Visitor;

public class MessageStop extends Message {

	@Override
	public void accept(Visitor visitor) {

			visitor.encode(this);

	}

}
