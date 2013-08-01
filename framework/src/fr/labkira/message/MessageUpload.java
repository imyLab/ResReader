package fr.labkira.message;

import java.awt.Image;
import java.util.UUID;

import fr.labkira.visitor.Visitor;


public class MessageUpload extends Message {

	private UUID IdPic;
	private Image img;

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public MessageUpload(Image img) {
		this.setImg(img);
	}

	@Override
	public void accept(Visitor visitor) {

		visitor.encode(this);

	}

	public UUID getIdPic() {
		return IdPic;
	}

	public void setIdPic(UUID idPic) {
		IdPic = idPic;
	}

}
