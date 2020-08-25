package view;

import javax.swing.JButton;

public class fakePopUpInput implements IPopUpInput{
	
	private JButton okButton,cancelButton;

	public fakePopUpInput() {
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
	}
	
	@Override
	public JButton getOkButton() {
		return okButton;
	}

	@Override
	public JButton getCancelButton() {
		return cancelButton;
	}

	@Override
	public String getTitle() {
		return "title";
	}

	@Override
	public String getAuthor() {
		return "author";
	}

	@Override
	public void dispose() {
		
	}
	
	
	

}
