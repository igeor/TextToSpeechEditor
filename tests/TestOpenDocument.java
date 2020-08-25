package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import files.IFileOpener;
import files.fakeFileOpener;
import model.Document;
import view.IPopUpOpen;
import view.Text2SpeechEditorView;
import view.fakePopUpOpen;

class TestOpenDocument {
	
	@Test
	void test() {
		String title = "title";
		String author = "author";
		String contents = "contents";
		
		Document doc = Text2SpeechEditorView.getInstance().getCurrentDocument();
		
		IPopUpOpen ppo = new fakePopUpOpen("path.txt");
		IFileOpener fo = new fakeFileOpener(title,author,contents);
		
		OpenDocument command = new OpenDocument( ppo, fo );
		command.execute();
		
		assertEquals(contents.trim(), doc.getDocContents().trim());
		System.out.println("Testing OpenDocument Success 1");
		assertEquals(title,doc.getTitle());
		System.out.println("Testing OpenDocument Success 2");
		assertEquals(author,doc.getAuthor());
		System.out.println("Testing OpenDocument Success 3");
	}

}
