package message;

import visitor.Visitor;
import visitor.Visitor.RequestType;

public class MessageAuthentification extends Message {

	private int UId;

	@Override
	public void accept(Visitor visitor, Visitor.RequestType t) {
		if (t.equals(RequestType.Encode)) {
			visitor.encode(this);
		} else if (t.equals(RequestType.Decode)) {
			visitor.decodeMessageAuthentification();
		}

	}

	public int getUId() {
		return UId;
	}

	public void setUId(int uId) {
		UId = uId;
	}

}
