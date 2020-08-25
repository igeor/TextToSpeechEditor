package view;

import javax.swing.JButton;

public interface IPopUpInput {
	
	public JButton getOkButton();
	public JButton getCancelButton();
	public String getTitle();
	public String getAuthor();
	public void dispose();
	
}
