package files;

public interface IFileAppender {
	public String appendContents(String filepath, String contents);
	public String getAppendedContents();
}
