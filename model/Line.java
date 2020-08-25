package model;

import java.util.ArrayList;

import EncodingStrategies.EncodingStrategy;
import text2speechApis.TextToSpeechAPI;

public class Line {
	
	private ArrayList <String> words = new ArrayList<String>();;
	private TextToSpeechAPI audioManager;
	private EncodingStrategy encodingStrategy;
	
	public Line(String line) {
		initLine(line);
	}

	private void initLine(String line) {
		String [] buffer;
		buffer=line.split("\\W+"); // na tsekaroume gia ta tabs
		
		for(int i=0;i<buffer.length; i++) {
			words.add(buffer[i]);
		}
		
	}
	
	public String toString() {
		String str="";
		for (int i=0; i<words.size(); i++) {
			str+= words.get(i)+" ";
		}
		return str;
	}
	
	public String toReverseString() {
		String str="";
		for (int i=words.size()-1 ; i>=0; i--) {
			str+= words.get(i)+" ";
		}
		return str;
	}
	
	public void playLine() {
		String line = "";
		for(String word: words) {
			line += word+" ";
		}
		audioManager.play(line);
	}

	public void setAdapterMode(TextToSpeechAPI audioManager) {
		this.audioManager = audioManager;
		
	}

	public void playReverseLine() {
		String line = "";
		for(int i=words.size()-1; i>=0; i--) {
			line+=words.get(i)+" ";
		}
		audioManager.play(line);
	}
	
	public void playEncodedLine() {
		String line = "";
		for(int i=0; i<words.size(); i++) {
			line+=words.get(i)+" ";
		}
		audioManager.play( encodingStrategy.encode( line ) );
	}
	
	public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}

}
