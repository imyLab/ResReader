package message;

import visitor.Visitor;
import visitor.Visitor.RequestType;

public class MessageStop extends Message {

	@Override
	public void accept(Visitor visitor, RequestType t) {
		if (t.equals(RequestType.Encode)) {
			visitor.encode(this);
		} else if (t.equals(RequestType.Decode)) {
			visitor.decodeMessageStop();
		}
	}

}
