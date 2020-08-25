package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import commands.DocumentToSpeech;
import commands.EditDocument;
import commands.ReplayCommand;
import commands.ReplayManager;
import model.Document;
import text2speechApis.TextToSpeechAPI;
import view.Text2SpeechEditorView;

class TestReplayCommand {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	void test() {
		//get Document 
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		doc.setAdapterMode("Test");
		TextToSpeechAPI audioManager = doc.getAudioManager();

		//put some stuff in document contets
		EditDocument command1 = new EditDocument();
		String contents = "The contents to be added";
		Text2SpeechEditorView.getInstance().getEditorPane().setText(contents);
		command1.execute();
		
		//play contents
		DocumentToSpeech command2 = new DocumentToSpeech();
		command2.execute("DocumentToSpeech");
		String playedBefore = audioManager.getPlayed();

		ReplayCommand command = new ReplayCommand(ReplayManager.getInstance());
		command.execute();
		
		String playedAfter = audioManager.getPlayed();
		
		assertEquals(playedBefore.strip(),playedAfter.strip());
		System.out.println("Testing ReplayCommand Success 1");
	}

}
