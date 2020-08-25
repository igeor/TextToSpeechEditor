package files;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import javax.swing.JOptionPane;

public class FileOpener implements IFileModifier,IFileOpener{
	
	private URL fileContentsURL;
	private File file;
	private BasicFileAttributes attr;
	private String fileContents;
	
	@Override
	public FileTime getCreationTime(String filepath) throws IOException {
		Path filePath = file.toPath();
		attr = Files.readAttributes(filePath, BasicFileAttributes.class);
		return attr.creationTime();
	}

	@Override
	public FileTime getModifiedTime(String filepath) throws IOException {
		Path filePath = file.toPath();
		attr = Files.readAttributes(filePath, BasicFileAttributes.class);
		return attr.lastModifiedTime();
	}

	@Override
	public void read(String path) {
		
		try {
			file = new File(path);
			Path filePath = Paths.get(path);
			fileContents = Files.readString(filePath, StandardCharsets.US_ASCII);
			fileContentsURL = file.toURI().toURL();
		} catch (IOException e) {
			
		}

	}

	@Override
	public URL getUrl() {
		return fileContentsURL;
	}
	
	public String [] getLoadedContents() {
		
		int newLineIndex = fileContents.indexOf("\n");
		
		String first = fileContents.substring(0, newLineIndex);
		String rest = fileContents.substring(newLineIndex + 1);

		String [] firstLine = first.split(":");
		
		String [] contents = new String[3];
		contents[0] = firstLine[0];
		contents[1] = firstLine[1];
		contents[2] = rest;
		return contents;
	}

}
