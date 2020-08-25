package commands;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import files.IFileModifier;
import files.IFileOpener;
import model.Document;
import view.EditorPane;
import view.FileChooser;
import view.IPopUpOpen;
import view.PopUpOpen;
import view.Text2SpeechEditorView;



public class OpenDocument implements ActionListener {

	private String selectedPath;
	private IPopUpOpen ppo;
	private JTextField pathField;
	private IFileOpener fo;
	
	public OpenDocument() {	}
	
	public OpenDocument(IFileOpener fo) {
		this.fo = fo;
	}
	
	public OpenDocument(IPopUpOpen ppo, IFileOpener fo) {
		this.fo = fo;
		this.ppo = ppo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ppo= new PopUpOpen();
		
		ppo.getBrowseButton().addActionListener(e1 -> browseFiles());
		ppo.getOkButton().addActionListener(e2 -> execute());
		ppo.getCancelButton().addActionListener(e3 -> closePopUpWindow());
		
		pathField = ppo.getTextField();
		
		if(! e.getActionCommand().equals("Replay")) {
			ReplayManager.getInstance().addActionListener(this);
		}
	}
	
	private void closePopUpWindow() {
		ppo.dispose();
	}

	public void execute() {
		
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		EditorPane editorPane = Text2SpeechEditorView.getInstance().getEditorPane();
		
		pathField = ppo.getTextField();
		selectedPath = pathField.getText();
		
		try {
			
			fo.read(selectedPath);
			String [] fileContents = fo.getLoadedContents();
			
			editorPane.setText(fileContents[2]); 
			
			doc.setCreationTime(((IFileModifier) fo).getCreationTime(selectedPath));
			doc.setLastModifiedTime(((IFileModifier) fo).getModifiedTime(selectedPath));
			doc.setPath(selectedPath);
			doc.setTitle(fileContents[0]);
			doc.setAuthor(fileContents[1]);
			
			EditDocument command = new EditDocument();
			command.execute();
			
			Text2SpeechEditorView.getInstance().setTitle(doc.getTitle(), doc.getAuthor());
			
			ppo.dispose();
			
		} catch (IOException | NullPointerException e) {			
			JOptionPane.showMessageDialog(Text2SpeechEditorView.getInstance().getFrame(),
				    "Couldnt Open file: "+selectedPath+" \n Please try to open a valid file type .txt!");
		}
	}

	private void browseFiles() {
		FileChooser fc = new FileChooser();
		selectedPath = fc.getPath("Open");
		ppo.getTextField().setText(selectedPath);
	}
	
	
}
