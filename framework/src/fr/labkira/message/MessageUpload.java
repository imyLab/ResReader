package fr.labkira.message;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import fr.labkira.visitor.Visitor;


public class MessageUpload extends Message {

	private UUID IdPic;
	private File file;

	

	public MessageUpload(UUID IdPic, File file) {
		this.setFile(file);
		this.setIdPic(IdPic);
	}

	@Override
	public void accept(Visitor visitor) throws IOException {

		visitor.encode(this);

	}

	public UUID getIdPic() {
		return IdPic;
	}

	public void setIdPic(UUID idPic) {
		IdPic = idPic;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
