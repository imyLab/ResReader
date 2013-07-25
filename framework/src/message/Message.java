package message;

import visitor.Visitor;

public abstract class Message {



	public void accept(Visitor visitor) {

			visitor.encode(this);

	}
}
