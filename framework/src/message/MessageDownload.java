package message;

import java.awt.Image;

import visitor.Visitor;
import visitor.Visitor.RequestType;

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
	public void accept(Visitor visitor, RequestType t) {
		if (t.equals(RequestType.Encode)) {
			visitor.encode(this);
		} else if (t.equals(RequestType.Decode)) {
			visitor.decodeMessageDownload();
		}
	}
}
