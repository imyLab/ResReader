package fr.labkira.message;



import java.io.IOException;

import fr.labkira.visitor.Visitor;

public abstract class Message {



	public void accept(Visitor visitor) throws IOException {

			visitor.encode(this);

	}
}
