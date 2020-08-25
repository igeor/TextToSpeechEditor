package view;

import javax.swing.JButton;
import javax.swing.JTextField;

public class fakePopUpOpen implements IPopUpOpen {
	private JTextField textField;
	private String path;
	
	public fakePopUpOpen(String path) {
		this.path = path;
		textField = new JTextField();
	}
	
	@Override
	public JButton getBrowseButton() {
		return new JButton();
	}

	@Override
	public JButton getOkButton() {
		return new JButton();
	}

	@Override
	public JButton getCancelButton() {
		// TODO Auto-generated method stub
		return new JButton();
	}

	@Override
	public JTextField getTextField() {
		textField.setText(path);
		return textField;
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
