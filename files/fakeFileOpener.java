package files;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.attribute.FileTime;
import java.util.Date;


public class fakeFileOpener implements IFileModifier,IFileOpener{

	private String path,title,author,contents;
	

	public fakeFileOpener(String title, String author, String contents) {
		this.title = title;
		this.author = author;
		this.contents = contents;
	}

	@Override
	public FileTime getCreationTime(String filepath) throws IOException {
		Date firstDate = new Date();
		FileTime fileTime = FileTime.fromMillis( firstDate.getTime() );
		   		    
		return fileTime;
	}

	@Override
	public FileTime getModifiedTime(String filepath) throws IOException {
		Date firstDate = new Date();
		FileTime fileTime = FileTime.fromMillis( firstDate.getTime() );
		   		    
		return fileTime;
	}

	@Override
	public void read(String path) {
		this.path = path;
	}

	@Override
	public URL getUrl() {
		return null;
	}
	
	public String [] getLoadedContents() {
		String [] contents_array = new String[] { title,author,contents };
		return contents_array;
	}
	
}
