package view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class FileChooser implements IFileChooser{
	
	private JFileChooser jfc;
	private int retValue;
	private String selectedPath;
	
	public FileChooser() {
	}
	
	public String getPath(String mode) {
		
		jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		jfc.setFileFilter(filter);
		
		int retValue;
		if(mode.equals("Open")) { //open
			retValue = jfc.showOpenDialog(null);
		}else {
			retValue = jfc.showSaveDialog(null);
		}
		
		if (retValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getCurrentDirectory();
			selectedPath = selectedFile.getAbsolutePath() +"\\" + jfc.getSelectedFile().getName();
			
		}
		return selectedPath;
	}
	
}
