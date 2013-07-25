package message;

import java.util.HashMap;
import java.util.Map;

import visitor.Visitor;

public class MessageListOfPics extends Message {

	Map<Integer, String> listPics = new HashMap<Integer, String>();

	public Map<Integer, String> getListPics() {
		return listPics;
	}

	public void setListPics(Map<Integer, String> listPics) {
		this.listPics = listPics;
	}

	@Override
	public void accept(Visitor visitor) {

			visitor.encode(this);

	}

}
