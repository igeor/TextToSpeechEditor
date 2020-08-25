package view;

public class fakeFileChooser implements IFileChooser{

	@Override
	public String getPath(String mode) {
		return "test.txt";
	}
	
}	

