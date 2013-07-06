package message;

import visitor.Visitor;
import visitor.Visitor.RequestType;

public abstract class Message {

	final static MessageType MESSAGE_TYPE = null;

	public enum MessageType {
		Ok, Error
	}

	public void accept(Visitor visitor, RequestType t) {
		if (t.equals(RequestType.Encode)) {
			visitor.encode(this);
		} else if (t.equals(RequestType.Decode)) {
			visitor.decode(this);
		}
	}
}
