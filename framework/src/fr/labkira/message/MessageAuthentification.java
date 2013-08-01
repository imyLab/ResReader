package fr.labkira.message;

import java.util.UUID;

import fr.labkira.visitor.Visitor;


public class MessageAuthentification extends Message {

	private UUID UId; 
	private String password;

	@Override
	public void accept(Visitor visitor) {

		visitor.encode(this);

	}

	public UUID getUId() {
		return UId;
	}

	public void setUId(UUID uId) {
		UId = uId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
