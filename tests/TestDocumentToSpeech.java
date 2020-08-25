package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.DocumentToSpeech;
import commands.EditDocument;
import commands.NewDocument;
import model.Document;
import text2speechApis.FakeTextToSpeechAPI;
import text2speechApis.TextToSpeechAPI;
import text2speechApis.TextToSpeechAPIFactory;
import view.IPopUpInput;
import view.Text2SpeechEditorView;
import view.fakePopUpInput;

class TestDocumentToSpeech {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		NewDocument newDocumentCmd = new NewDocument((IPopUpInput) new fakePopUpInput());
		newDocumentCmd.execute();
		
		
		
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
		
		DocumentToSpeech command2 = new DocumentToSpeech();
		command2.execute("DocumentToSpeech");
		String played = audioManager.getPlayed();
		
		assertEquals(contents.trim(), played.trim());
		System.out.println("Testing DocumentToSpeech Success 1");
	}

}
