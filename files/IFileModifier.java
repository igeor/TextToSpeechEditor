package files;

import java.io.IOException;
import java.nio.file.attribute.FileTime;

public interface IFileModifier {
			
	public FileTime getCreationTime(String filepath) throws IOException;
	public FileTime getModifiedTime(String filepath) throws IOException;

}
