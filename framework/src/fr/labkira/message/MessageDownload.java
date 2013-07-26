package fr.labkira.message;

import java.awt.Image;

import fr.labkira.visitor.Visitor;


public class MessageDownload extends Message {

	private int UIdPic;
	public Image img;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public MessageDownload(Image img) {
		this.setImg(img);
	}

	public int getUIdPic() {
		return UIdPic;
	}

	public void setUIdPic(int uIdPic) {
		UIdPic = uIdPic;
	}

	@Override
	public void accept(Visitor visitor) {

			visitor.encode(this);
		
	}
}
