package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import files.IFileAppender;
import files.IFileModifier;
import model.Document;
import view.EditorPane;
import view.IFileChooser;
import view.Text2SpeechEditorView;

public class SaveDocument implements ActionListener {

	private String selectedPath;
	private IFileChooser jfc;
	private IFileAppender fa;
	
	public SaveDocument() {	}
	

	public SaveDocument(IFileChooser jfc, IFileAppender fa) {
		this.jfc = jfc;
		this.fa = fa;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		execute();
		
		if(! e.getActionCommand().equals("Replay")) {
			ReplayManager.getInstance().addActionListener(this);
		}
	}

	
	public void execute() {
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		EditorPane editorPane = Text2SpeechEditorView.getInstance().getEditorPane();
		
		//if file had been already saved in directory
		if(doc.getPath().equals("noPath")) {
			selectedPath = jfc.getPath("Save");
		}else {
			selectedPath = doc.getPath();
		}
		
		if(selectedPath != null && !selectedPath.isEmpty()) {
			String appendedContents = doc.getTitle()+":"+doc.getAuthor()+"\n"+editorPane.getText();
			fa.appendContents(selectedPath, appendedContents);
			
			try {
				// edit document
				doc.setPath(selectedPath);
				doc.setCreationTime(((IFileModifier) fa).getCreationTime(selectedPath));
				doc.setLastModifiedTime(((IFileModifier) fa).getModifiedTime(selectedPath));
				
				EditDocument command = new EditDocument();
				command.execute();
				// edit document

			} catch (IOException | NullPointerException e) {
				JOptionPane.showMessageDialog(Text2SpeechEditorView.getInstance().getFrame(),
					    "Couldnt Open file: "+selectedPath+" \n Please try to open a valid file type .txt!");
			}
		}
		

	}
	
}


