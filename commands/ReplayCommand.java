package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplayCommand implements ActionListener {
	
	private ReplayManager repManager;
	
	public ReplayCommand (ReplayManager repManager) {
		this.repManager = repManager;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		execute();
	}
	
	public void execute() {
		repManager.replay();
	}
}
