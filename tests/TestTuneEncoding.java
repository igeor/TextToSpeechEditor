package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import commands.TuneEncoding;
import view.Text2SpeechEditorView;

class TestTuneEncoding {

	@Test
	void test() {
		
		String prevEncodingStrategy = Text2SpeechEditorView.getInstance().getEncodeOption();
		
		Text2SpeechEditorView.getInstance().getEncodingButton("AtBash").setSelected(true);

		TuneEncoding command = new TuneEncoding();
		command.execute();
		
		String afterEncodingStrategy = Text2SpeechEditorView.getInstance().getEncodeOption();
		
		assertTrue(! prevEncodingStrategy.equals(afterEncodingStrategy));
		System.out.println("Testing TuneEncoding Success 1");
	}

}
