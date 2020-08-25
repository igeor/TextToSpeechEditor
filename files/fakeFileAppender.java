package files;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.Date;

public class fakeFileAppender implements IFileModifier,IFileAppender{
	
	private File test;
	private String testPath = "testfile.txt";
	private String contents;
	
	public fakeFileAppender() {
		test =  new File(testPath);
	}
	
	public String appendContents(String filepath, String contents) {
		this.contents = contents;
		return contents;
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

	public String getAppendedContents() {
		return contents;
	}
	
	

}
