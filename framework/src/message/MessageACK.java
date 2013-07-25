package message;

import visitor.Visitor;

public class MessageACK extends Message {

	public enum MessageType {
		Ok, Error
	}

	private MessageType type;
	private String description;

	@Override
	public void accept(Visitor visitor) {

		visitor.encode(this);

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
