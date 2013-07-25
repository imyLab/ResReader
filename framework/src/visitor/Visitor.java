package visitor;

import message.Message;
import message.MessageACK;
import message.MessageAuthentification;
import message.MessageDownload;
import message.MessageListOfPics;
import message.MessageStop;
import message.MessageUpload;

public interface Visitor {

	public abstract void encode(Message m);

	public abstract void encode(MessageAuthentification ma);

	public abstract void encode(MessageACK mack);

	public abstract void encode(MessageDownload md);

	public abstract void encode(MessageUpload mu);

	public abstract void encode(MessageStop ms);

	public abstract void encode(MessageListOfPics ml);

}
