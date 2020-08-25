package view;

import javax.swing.JButton;
import javax.swing.JTextField;

public interface IPopUpOpen {
	
	public JButton getBrowseButton();
	public JButton getOkButton() ;
	public JButton getCancelButton();
	public JTextField getTextField();
	public void setVisible(boolean b);
	public void dispose();
	
}
