package commands;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import model.Document;
import view.EditorPane;
import view.IPopUpInput;
import view.PopUpInput;
import view.Text2SpeechEditorView;

public class NewDocument implements ActionListener {
	
	private IPopUpInput ppi;
	
	//testing
	public NewDocument() {}
	
	public NewDocument(IPopUpInput ppi) {
		this.ppi = ppi;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ppi = new PopUpInput();
		ppi.getCancelButton().addActionListener(e1->close());
		ppi.getOkButton().addActionListener(e2->execute());
		
		if(! e.getActionCommand().equals("Replay")) {
			ReplayManager.getInstance().addActionListener(this);
		}
	}


	public void execute() {
		String title = ppi.getTitle();
		String author = ppi.getAuthor();
		Text2SpeechEditorView.getInstance().setTitle(author, title);
				
		Text2SpeechEditorView.getInstance().newDocument();
		Text2SpeechEditorView.getInstance().getCurrentDocument().setTitle(title);
		Text2SpeechEditorView.getInstance().getCurrentDocument().setAuthor(author);
		Text2SpeechEditorView.getInstance().getCurrentDocument().setEncodeStrategy("Rot13");
		Text2SpeechEditorView.getInstance().getEditorPane().setText("");
		Text2SpeechEditorView.getInstance().getEditorPane().setEditable(true);
	}

	private void close() {
		ppi.dispose();
	}
}
