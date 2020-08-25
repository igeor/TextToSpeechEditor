package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import commands.EditDocument;
import commands.OpenDocument;
import commands.SaveDocument;
import files.IFileAppender;
import files.IFileOpener;
import files.fakeFileAppender;
import files.fakeFileOpener;
import model.Document;
import view.IFileChooser;
import view.IPopUpOpen;
import view.Text2SpeechEditorView;
import view.fakeFileChooser;
import view.fakePopUpOpen;

class TestSaveDocument {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String title = "title";
		String author = "author";
		String contents = "contents";
		
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		
		IPopUpOpen ppo = new fakePopUpOpen("path.txt");
		IFileOpener fo = new fakeFileOpener(title,author,contents);
		
		OpenDocument command = new OpenDocument( ppo, fo );
		command.execute();
		
		assertEquals(contents.trim(), doc.getDocContents().trim());
		assertEquals(title,doc.getTitle());
		assertEquals(author,doc.getAuthor());
		
		EditDocument edit_command = new EditDocument();
		String contents_appended = "The contents to be added";
		Text2SpeechEditorView.getInstance().getEditorPane().setText(contents_appended);
		edit_command.execute();
	}


	@Test
	void test() {
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		IFileChooser jfc = new fakeFileChooser();
		IFileAppender fa = new fakeFileAppender();
		
		SaveDocument command = new SaveDocument(jfc,fa);
		command.execute();
		
		String document_contents = Text2SpeechEditorView.getInstance().getCurrentDocument().getAllContents();
		String contets_appended = fa.getAppendedContents();
		
		assertEquals(document_contents.trim(),contets_appended.trim());
		System.out.println("Testing SaveDocument Success 1");
		
	}

}
