package files;

import java.net.URL;

public interface IFileOpener {
	public void read(String path);
	public URL getUrl();
	public String [] getLoadedContents();
}
