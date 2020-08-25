package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import commands.EditDocument;
import model.Document;
import view.Text2SpeechEditorView;

class TestEditDocument {
	
	static Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();

	@Test
	void test() {
		EditDocument command = new EditDocument();
		
		String contents = "The contents to be added";
		Text2SpeechEditorView.getInstance().getEditorPane().setText(contents);
		command.execute();
		Assertions.assertEquals(contents.trim(), doc.getDocContents().trim());
		System.out.println("Testing EditDocument Success 1");

		contents = "";
		Text2SpeechEditorView.getInstance().getEditorPane().setText(contents);
		command.execute();
		Assertions.assertEquals(contents.trim(), doc.getDocContents().trim());
		System.out.println("Testing EditDocument Success 2");
		
		contents = "a foajsfasfa fasf afa1212 fspafaafuASFuASFASGASgASghajSGAS";
		Text2SpeechEditorView.getInstance().getEditorPane().setText(contents);
		command.execute();
		Assertions.assertEquals(contents.trim(), doc.getDocContents().trim());
		System.out.println("Testing EditDocument Success 3");
	}

}
