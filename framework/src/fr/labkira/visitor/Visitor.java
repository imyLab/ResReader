package fr.labkira.visitor;





import java.io.IOException;

import fr.labkira.message.Message;
import fr.labkira.message.MessageACK;
import fr.labkira.message.MessageAuthentification;
import fr.labkira.message.MessageDownload;
import fr.labkira.message.MessageListOfPics;
import fr.labkira.message.MessageStop;
import fr.labkira.message.MessageUpload;

public interface Visitor {

	public abstract void encode(Message m) throws IOException;

	public abstract void encode(MessageAuthentification ma);

	public abstract void encode(MessageACK mack);

	public abstract void encode(MessageDownload md) throws IOException ;

	public abstract void encode(MessageUpload mu);

	public abstract void encode(MessageStop ms);

	public abstract void encode(MessageListOfPics ml);

}
