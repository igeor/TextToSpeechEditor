package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import view.Text2SpeechEditorView;

public class ReplayManager {
	
	private Stack <ActionListener> listeners = new Stack<ActionListener>();
	private static ReplayManager instance;
	
	public ReplayManager() {}
	
	
	public void replay() {
		
		if(! listeners.isEmpty()) {
			ActionListener listener = listeners.pop();
			ActionEvent event = new ActionEvent(Text2SpeechEditorView.getInstance().getReplayCommand(), 0, "Replay");
			listener.actionPerformed(event);
		}
	}

	
	public static ReplayManager getInstance() {
		if(instance == null) {
			instance = new ReplayManager();
		}
		return instance;
		
	}


	public void addActionListener(ActionListener listener) {
		listeners.add(listener);
	}
}
