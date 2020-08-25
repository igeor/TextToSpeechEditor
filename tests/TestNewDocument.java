package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import commands.NewDocument;
import view.IPopUpInput;
import view.Text2SpeechEditorView;
import view.fakePopUpInput;


public class TestNewDocument {
	
	public TestNewDocument() {}
	
	@Test
	void test1() {
		NewDocument newDocumentCmd = new NewDocument((IPopUpInput) new fakePopUpInput());
		newDocumentCmd.execute();
		Assertions.assertTrue(! Text2SpeechEditorView.getInstance().getCurrentDocument().getAllContents().isEmpty());
		System.out.println("Testing NewDocument Success 1");
	}
}
