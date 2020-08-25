package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Document;
import view.Text2SpeechEditorView;

public class TuneAudio implements ActionListener{
			
	public TuneAudio() {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		execute();
		
		if(! e.getActionCommand().equals("Replay")) {
			ReplayManager.getInstance().addActionListener(this);
		}				
	}

	public void execute() {
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		
		int volume = Text2SpeechEditorView.getInstance().getVolume();
		int rate = Text2SpeechEditorView.getInstance().getRate();
		int pitch = Text2SpeechEditorView.getInstance().getPitch();
		
		doc.getAudioManager().setVolume(volume);
		doc.getAudioManager().setPitch(pitch);
		doc.getAudioManager().setRate(rate);
	}

	
	
}
