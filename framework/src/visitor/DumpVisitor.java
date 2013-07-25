package visitor;

import message.Message;
import message.MessageACK;
import message.MessageAuthentification;
import message.MessageDownload;
import message.MessageListOfPics;
import message.MessageStop;
import message.MessageUpload;



public class DumpVisitor implements Visitor {

	private MessageAuthentification ma;
	private MessageACK mack;
	private MessageDownload md;
	private MessageListOfPics ml;
	private MessageStop ms;
	private MessageUpload mu;

	@Override
	public void encode(MessageAuthentification ma) {
		System.out.println("Encode le message " + ma.getUId());

	}

	@Override
	public void encode(Message m) {
		System.out.println("Encode le message");

	}

	@Override
	public MessageAuthentification decodeMessageAuthentification() {

		System.out.println("Decode le message " + this.getMa().getUId());

		return null;
	}

	@Override
	public MessageACK decodeMessageACK() {
		System.out.println("Decode le message "
				+ this.getMack().getDescription() + " de type "
				+ this.getMack().getType());
		return null;
	}

	@Override
	public void encode(MessageACK mack) {
		System.out.println("Encode le message " + mack.getDescription()
				+ " de type " + mack.getType());

	}

	@Override
	public void encode(MessageDownload md) {
		System.out.println("Encode le message contenant l'image "
				+ md.getUIdPic());

	}

	@Override
	public void encode(MessageUpload mu) {
		System.out.println("Encode le message contenant l'image "
				+ mu.getIdPic());

	}

	@Override
	public void encode(MessageStop ms) {
		System.out.println("Encode le message Stop");

	}

	@Override
	public void encode(MessageListOfPics ml) {
		System.out.println("Encode le message contenant la liste des images "
				+ ml.getListPics().toString());

	}

	@Override
	public void decode(Message m) {
		// TODO Auto-generated method stub

	}

	@Override
	public MessageDownload decodeMessageDownload() {
		System.out.println("Decode le message contenant l'image "
				+ this.getMd().getUIdPic());

		return null;
	}

	@Override
	public MessageUpload decodeMessageUpload() {
		System.out.println("Decode le message" + this.getMa().getUId());
		return null;
	}

	@Override
	public MessageStop decodeMessageStop() {
		System.out.println("Decode le message" + this.getMs());

		return null;
	}

	@Override
	public MessageListOfPics decodeMessageListOfPics() {
		System.out.println("Decode le message"
				+ this.getMl().getListPics().toString());

		return null;
	}

	public MessageACK getMack() {
		return mack;
	}

	public void setMack(MessageACK mack) {
		this.mack = mack;
	}

	public MessageDownload getMd() {
		return md;
	}

	public void setMd(MessageDownload md) {
		this.md = md;
	}

	public MessageListOfPics getMl() {
		return ml;
	}

	public void setMl(MessageListOfPics ml) {
		this.ml = ml;
	}

	public MessageStop getMs() {
		return ms;
	}

	public void setMs(MessageStop ms) {
		this.ms = ms;
	}

	public MessageUpload getMu() {
		return mu;
	}

	public void setMu(MessageUpload mu) {
		this.mu = mu;
	}

	public MessageAuthentification getMa() {
		return ma;
	}

	public void setMa(MessageAuthentification ma) {
		this.ma = ma;
	}

}