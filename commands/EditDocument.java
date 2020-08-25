package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Document;
import view.IPopUpInput;
import view.Text2SpeechEditorView;

public class EditDocument implements ActionListener {
	
	public EditDocument() {	}
	
	
	public EditDocument(IPopUpInput ppi) {	}


	@Override
	public void actionPerformed(ActionEvent e) {
		execute();
		if(! e.getActionCommand().equals("Replay")) {
			ReplayManager.getInstance().addActionListener(this);
		}

	}
	
	public void execute() {
		String editorContent = 	Text2SpeechEditorView.getInstance().getEditorPane().getText();
		Text2SpeechEditorView.getInstance().getCurrentDocument().editContents(editorContent);
		Text2SpeechEditorView.getInstance().getEditorPane().setEditable(true);

	}
	
	
}
