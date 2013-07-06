package visitor;

import message.Message;
import message.MessageACK;
import message.MessageAuthentification;
import message.MessageDownload;
import message.MessageListOfPics;
import message.MessageStop;
import message.MessageUpload;

public interface Visitor {

	public static enum RequestType {

		Encode, Decode
	}

	void encode(Message m);

	void encode(MessageAuthentification ma);

	void encode(MessageACK mack);

	void encode(MessageDownload md);

	void encode(MessageUpload mu);

	void encode(MessageStop ms);

	void encode(MessageListOfPics ml);

	void decode(Message m);

	MessageAuthentification decodeMessageAuthentification();

	MessageACK decodeMessageACK();

	MessageDownload decodeMessageDownload();

	MessageUpload decodeMessageUpload();

	MessageStop decodeMessageStop();

	MessageListOfPics decodeMessageListOfPics();

}
