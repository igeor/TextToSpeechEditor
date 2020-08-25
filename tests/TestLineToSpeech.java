package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.EditDocument;
import commands.LineToSpeech;
import commands.NewDocument;
import model.Document;
import text2speechApis.TextToSpeechAPI;
import view.IPopUpInput;
import view.Text2SpeechEditorView;
import view.fakePopUpInput;

class TestLineToSpeech {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		NewDocument newDocumentCmd = new NewDocument((IPopUpInput) new fakePopUpInput());
		newDocumentCmd.execute();
	}

	@Test
	void test() {
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		doc.setAdapterMode("Test");
		TextToSpeechAPI audioManager = doc.getAudioManager();
		
		EditDocument command = new EditDocument();
		String contents = "The contents to be added";
		Text2SpeechEditorView.getInstance().getEditorPane().setText(contents);
		command.execute();
		
		LineToSpeech command2 = new LineToSpeech();
		command2.execute("LineToSpeech");
		String played = audioManager.getPlayed();
		
		assertEquals(contents.trim(), played.trim());
		System.out.println("Testing LineToSpeech Success 1");
	}

}
