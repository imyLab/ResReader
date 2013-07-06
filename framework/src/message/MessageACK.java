package message;

import visitor.Visitor;
import visitor.Visitor.RequestType;

public class MessageACK extends Message {

	private MessageType type;
	private String description;

	@Override
	public void accept(Visitor visitor, RequestType t) {
		if (t.equals(RequestType.Encode)) {
			visitor.encode(this);
		} else if (t.equals(RequestType.Decode)) {
			visitor.decodeMessageACK();
		}

	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
