package message;

import java.awt.Image;

import visitor.Visitor;

public class MessageUpload extends Message {

	private int IdPic;
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

	public int getIdPic() {
		return IdPic;
	}

	public void setIdPic(int idPic) {
		IdPic = idPic;
	}

}
