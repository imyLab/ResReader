package fr.labkira.message;

import java.awt.Image;
import java.io.IOException;
import java.util.UUID;

import fr.labkira.visitor.Visitor;


public class MessageDownload extends Message {

	private UUID UIdPic;
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

	public UUID getUIdPic() {
		return UIdPic;
	}

	public void setUIdPic(UUID uIdPic) {
		UIdPic = uIdPic;
	}

	@Override
	public void accept(Visitor visitor) throws IOException {

			visitor.encode(this);
		
	}
}
