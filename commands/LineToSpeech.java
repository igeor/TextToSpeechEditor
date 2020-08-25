package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import view.EditorPane;
import view.Text2SpeechEditorView;
import model.Document;

public class LineToSpeech implements ActionListener{
	
	private Stack <Integer> Lines = new Stack <Integer> ();
	private Stack <String> modes = new Stack<String>();

	@Override
	public void actionPerformed(ActionEvent e) {		
		execute(e.getActionCommand());
	}
	
	public void execute(String mode) {
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		EditorPane editorPane = Text2SpeechEditorView.getInstance().getEditorPane();

		int selectedLine = editorPane.getSelectedLine();
		
		if(mode.equals("Replay")) {
			selectedLine = Lines.pop();		
			String replayMode = modes.pop();
			if(replayMode.equals("Reversed Line")) {
				doc.playReverseLine(selectedLine);
			}else if(replayMode.equals("Encoded Line")) {
				doc.playEncodedLine(selectedLine);
			}else {
				doc.playLine(selectedLine);
			}
		}else { 
			selectedLine = editorPane.getSelectedLine();
			Lines.add(selectedLine);
			ReplayManager.getInstance().addActionListener(this);
			if(mode.equals("Reversed Line")) {
				doc.playReverseLine(selectedLine);
			}else if(mode.equals("Encoded Line")) {
				doc.playEncodedLine(selectedLine);
			}else {
				doc.playLine(selectedLine);
			}
			modes.add(mode);
		}
		
		
	}
}
