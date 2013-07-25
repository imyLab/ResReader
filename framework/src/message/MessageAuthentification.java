package message;

import visitor.Visitor;

public class MessageAuthentification extends Message {

	private int UId;

	@Override
	public void accept(Visitor visitor) {

			visitor.encode(this);


	}

	public int getUId() {
		return UId;
	}

	public void setUId(int uId) {
		UId = uId;
	}

}
