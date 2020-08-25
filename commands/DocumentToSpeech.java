package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import model.Document;
import view.Text2SpeechEditorView;
	
public class DocumentToSpeech implements ActionListener{
	
	private Stack <String> modes = new Stack<String>();

	@Override
	public void actionPerformed(ActionEvent e) {
		execute(e.getActionCommand());
		
		if(! e.getActionCommand().equals("Replay")) {
			ReplayManager.getInstance().addActionListener(this);
		}
	}
	
	public void execute(String mode) {
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		
		if(mode.equals("Replay")) {
			mode = modes.pop();
			if(mode.equals("Reversed Document")){
				doc.playReverseContents();
			}else if(mode.equals("Encoded Document")) {
				doc.playEncodedContents();
			}else {
				doc.playContents();
			}
		}else {
			if(mode.equals("Reversed Document")){
				doc.playReverseContents();
			}else if(mode.equals("Encoded Document")) {
				doc.playEncodedContents();
			}else {
				doc.playContents();
			}
			modes.add(mode);
		}
		
		
	}

}
