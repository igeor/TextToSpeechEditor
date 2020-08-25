package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import commands.TuneAudio;
import view.Text2SpeechEditorView;

class TestTuneAudio {

	@Test
	void test() {
		String volume = Integer.toString(Text2SpeechEditorView.getInstance().getVolume());
		String rate = Integer.toString(Text2SpeechEditorView.getInstance().getVolume());
		String pitch = Integer.toString(Text2SpeechEditorView.getInstance().getPitch());
		
		String initPreferences = volume+" "+rate+" "+pitch;
		
		Text2SpeechEditorView.getInstance().setAudioParameters("80", "100", "100");
		TuneAudio command = new TuneAudio();
		command.execute();
		
		String volume1 = Integer.toString(Text2SpeechEditorView.getInstance().getVolume());
		String rate1 = Integer.toString(Text2SpeechEditorView.getInstance().getVolume());
		String pitch1 = Integer.toString(Text2SpeechEditorView.getInstance().getPitch());
		
		String afterPreferences = volume1+" "+rate1+" "+pitch1;
		
		assertTrue(! initPreferences.equals(afterPreferences));
		System.out.println("Testing TuneAudio Success 1");
	}

}
