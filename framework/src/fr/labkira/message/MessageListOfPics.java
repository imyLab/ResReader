package fr.labkira.message;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import fr.labkira.visitor.Visitor;


public class MessageListOfPics extends Message {

	Map<UUID, String> listPics = new HashMap<UUID, String>();

	public Map<UUID, String> getListPics() {
		return listPics;
	}

	public void setListPics(Map<UUID, String> listPics) {
		this.listPics = listPics;
	}

	@Override
	public void accept(Visitor visitor) {

			visitor.encode(this);

	}

}
