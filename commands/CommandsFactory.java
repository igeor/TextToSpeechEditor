package commands;

/*
 * Considering the argument 
 * that the class receives, creates 
 * an instance of a specific command
 * Constructs ActionListener object
 */

import java.awt.event.ActionListener;

import files.FileAppender;
import files.FileOpener;
import view.FileChooser;

public class CommandsFactory {
		
		
	public ActionListener createCommand(String cmd){
				
		switch(cmd) {
			
			case ("NewDocument"):
				
				NewDocument newDoc = new NewDocument();
				return newDoc;	
			
			case ("OpenDocument"):
				OpenDocument openDoc = new OpenDocument(new FileOpener());
				return openDoc;
			
			case ("SaveDocument"):
				
				SaveDocument saveDoc = new SaveDocument( new FileChooser(), new FileAppender());
				return saveDoc;
				
			case ("EditDocument"):
				EditDocument editDoc = new EditDocument();
				return editDoc;
			
			case ("DocumentToSpeech"):
				DocumentToSpeech docToSpeech = new DocumentToSpeech();
				return docToSpeech;
				
			case ("LineToSpeech"):
				LineToSpeech lineToSpeech = new LineToSpeech();
				return lineToSpeech;
				
			case ("TuneEncoding"):
				TuneEncoding tuneEncLine = new TuneEncoding();
				return tuneEncLine;
			
			case ("TuneAudio"):
				TuneAudio tuneAudio = new TuneAudio();
				return tuneAudio;
			
			case ("ReplayCommand"):
				ReplayCommand replayCmd = new ReplayCommand( ReplayManager.getInstance() );
				return replayCmd;
				
		}
		
		return null;
	}

	
}
