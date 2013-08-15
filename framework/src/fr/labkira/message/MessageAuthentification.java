package fr.labkira.message;

import java.util.UUID;

import fr.labkira.visitor.Visitor;

public class MessageAuthentification extends Message {

	private UUID UId;
	private String password;
	private String UserName;

	public MessageAuthentification(UUID UId, String password, String UserName) {
		this.setPassword(password);
		this.setUId(UId);
		this.setUserName(UserName);
	}

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

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

}
