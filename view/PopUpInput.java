package view;

import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PopUpInput extends JDialog implements IPopUpInput {

	private final JPanel contentPanel = new JPanel();
	private String author,title;
	private JTextField titleField,authorField;
	private JButton okButton, cancelButton;
	
	public PopUpInput() {
		setTitle("Create New Document");
		setBounds(100, 100, 317, 135);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblAuthor_1 = new JLabel("Title");
				panel.add(lblAuthor_1);
			}
			{
				titleField = new JTextField();
				titleField.setColumns(10);
				panel.add(titleField);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			{
				JLabel lblAuthor = new JLabel("Author");
				panel.add(lblAuthor);
			}
			{
				authorField = new JTextField();
				authorField.setColumns(10);
				panel.add(authorField);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							title = titleField.getText();
							author = authorField.getText();
							//handle inputs
							
							PopUpInput.this.dispose();
						}
					}
				);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PopUpInput.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setVisible(true);
	}

	public JButton getOkButton() {
		return okButton;
	}
	
	public JButton getCancelButton() {
		return cancelButton;
	}

	public String getAuthor() {
		return authorField.getText();
	}

	public String getTitle() {
		return titleField.getText();
	}

}
