package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import model.Document;
import view.EditorPane;
import view.Text2SpeechEditorView;

public class TuneEncoding implements ActionListener{
	
	private String Docmode;
	private Stack <Integer> Lines = new Stack <Integer> ();

	
	@Override
	public void actionPerformed(ActionEvent e) {
		execute();
		
		if(! e.getActionCommand().equals("Replay")) {
			ReplayManager.getInstance().addActionListener(this);
		}
		
	}
	
	public void execute() {
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		doc.setEncodeStrategy(Text2SpeechEditorView.getInstance().getEncodeOption());
	}
	
	

}
