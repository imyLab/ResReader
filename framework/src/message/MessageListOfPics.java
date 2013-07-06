package message;

import java.util.HashMap;
import java.util.Map;

import visitor.Visitor;
import visitor.Visitor.RequestType;

public class MessageListOfPics extends Message {

	Map<Integer, String> listPics = new HashMap<Integer, String>();

	@Override
	public void accept(Visitor visitor, RequestType t) {
		if (t.equals(RequestType.Encode)) {
			visitor.encode(this);
		} else if (t.equals(RequestType.Decode)) {
			visitor.decodeMessageListOfPics();
		}
	}

}
