package fr.labkira.message;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import fr.labkira.visitor.Visitor;


public class MessageDownload extends Message {

	private UUID UIdPic;
	public File file;
	
	public MessageDownload(UUID id, File file){
		this.setUIdPic(UIdPic);
		this.setFile(file);
		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public UUID getUIdPic() {
		return UIdPic;
	}

	public void setUIdPic(UUID uIdPic) {
		UIdPic = uIdPic;
	}

	@Override
	public void accept(Visitor visitor) throws IOException  {

			visitor.encode(this);
		
	}
}
