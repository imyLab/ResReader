package message;

import java.awt.Image;

import visitor.Visitor;
import visitor.Visitor.RequestType;

public class MessageUpload extends Message {

	private int IdPic;
	public Image img;

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
	public void accept(Visitor visitor, RequestType t) {
		if (t.equals(RequestType.Encode)) {
			visitor.encode(this);
		} else if (t.equals(RequestType.Decode)) {
			visitor.decodeMessageUpload();
		}
	}

	public int getIdPic() {
		return IdPic;
	}

	public void setIdPic(int idPic) {
		IdPic = idPic;
	}

}
