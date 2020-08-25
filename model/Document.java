package model;

import java.util.ArrayList;

import EncodingStrategies.AtBashEncoding;
import EncodingStrategies.EncodingStrategy;
import EncodingStrategies.Rot13Encoding;
import java.nio.file.attribute.FileTime;
import text2speechApis.TextToSpeechAPI;
import text2speechApis.TextToSpeechAPIFactory;

public class Document {
	
	private FileTime creationTime,lastModifiedTime;
	private String title,author;
	private ArrayList <Line> Lines = new ArrayList<Line>();
	private String path = "noPath";
	
	private TextToSpeechAPIFactory t2SFact;
	private TextToSpeechAPI audioManager;
	private EncodingStrategy encodingStrategy;
	
	
	public Document() {
		t2SFact = new TextToSpeechAPIFactory();
	}
	
	public void playContents() {
		audioManager.play(getDocContents());
	}
	
	public void playLine(int index) {
		if(index>=Lines.size()) {
			Lines.get(Lines.size()-1).playLine();
		}else {
			Lines.get(index).playLine();
		}
	}

	public void playReverseContents() {
		audioManager.play(getReverseDocContets());
	}
	
	public void playReverseLine(int index) {
		Lines.get(index).playReverseLine();
	}
	
	
	public void playEncodedContents() {
		audioManager.play( encodingStrategy.encode( getDocContents()) );
	}
	
	
	public void playEncodedLine(int index) {
		Lines.get(index).playEncodedLine();
	}






	
	
	////////////////////////////////////////////////////////////////////////////////
	// 		SETTERS
	////////////////////////////////////////////////////////////////////////////////
	

	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCreationTime(FileTime creationTime) {
		this.creationTime = creationTime;
	}
	
	public void setLastModifiedTime(FileTime lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}    
	 
	
	
	public void editContents(String contents) {
		Lines.clear();
		String [] buffer = contents.split("\\n");
		for(int i=0; i<buffer.length; i++) {
			Line line = new Line(buffer[i]);
			line.setAdapterMode(audioManager);
			line.setEncodingStrategy(encodingStrategy);
			Lines.add(line);
		}
	}
	
	public void setPath(String path) {
		if(path!=null || path!="") {
			this.path = path;
		}
	}
	
	public void setAdapterMode(String mode) {
		this.audioManager = t2SFact.createTTSAP(mode);
		for(Line line: Lines) {
			line.setAdapterMode(audioManager);
		}
	}
		
	public void setEncodeStrategy(String encodeOption) {
		if(encodeOption.equals("Rot13")) { 
			encodingStrategy = new Rot13Encoding();
		}else if(encodeOption.equals("AtBash")) {
			encodingStrategy = new AtBashEncoding();
		}
		for(Line line: Lines) {
			line.setEncodingStrategy(encodingStrategy);
		}
	}
	////////////////////////////////////////////////////////////////////////////////
	// 		GETTERS
	////////////////////////////////////////////////////////////////////////////////
	
	
	
	public String getPath() {
		return path;
	}
	
	public String getAllContents() {
		String label = title+":"+author+"\n";
		label += getDocContents();
		return label;
	}
	public String getDocContents() {
		String contents = "";
		for(Line line: Lines) {
			contents += line.toString() + "\n";
		}
		return contents;
	}
	
	public String getReverseDocContets() {
		String str = "";
		for(int i=Lines.size()-1; i>=0; i--) {
			str+=Lines.get(i).toReverseString();
		}
		return str;
	}
	
	public TextToSpeechAPI getAudioManager() {
		return audioManager;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public FileTime getDateCreated() {
		return this.creationTime;
	}
	
	public FileTime getDateModified() {
		return this.lastModifiedTime;
	}
	
	
	public String toString() {
		return "author:"+author+", title: "+title+", path: "+path+", creationTime: "+creationTime+", lastModifiedTime: "+lastModifiedTime;
	}
	
	
	

}
