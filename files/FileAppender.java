package files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileAppender implements IFileModifier,IFileAppender{
	
	private File file;
	private BasicFileAttributes attr;
	private String contents;
	
	public FileAppender() {
	}
	
	public String appendContents(String filepath, String contents) {
		file = new File(filepath);
		this.contents = contents;
		BufferedWriter writer = null;
		try {
			//append everything from editor to file
			writer = new BufferedWriter(new FileWriter(filepath));
			writer.write(contents);
			writer.close();
			
		} catch (IOException e1) {
			e1.printStackTrace();
			
		}
		
		return contents;
		
	}

	public FileTime getCreationTime(String filepath) throws IOException {
		Path filePath = file.toPath();
		attr = Files.readAttributes(filePath, BasicFileAttributes.class);
		return attr.creationTime();
	}
	
	public FileTime getModifiedTime(String filepath) throws IOException {
		Path filePath = file.toPath();
		attr = Files.readAttributes(filePath, BasicFileAttributes.class);
		return attr.lastModifiedTime();
	}

	public String getAppendedContents() {
		return contents;
	}
}
