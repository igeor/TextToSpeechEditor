package text2speechApis;

import model.*;

public class FakeTextToSpeechAPI implements TextToSpeechAPI{
	
	private String str;
	private int volume,pitch,rate;
		
	@Override
	public void play(String str) {	this.str = str; }
	@Override
	public void setVolume(int volume) { this.volume = volume;	}
	@Override
	public void setPitch(int pitch) {  this.pitch = pitch;	}
	@Override
	public void setRate(int rate) {  this.rate = rate;	}
	
	public String getPlayedContents() { return this.str; }
	public int getVolume() { return this.volume; }
	public int getPitch() { return this.pitch; }
	public int getRate() { return this.rate; }
	public String getPlayed() {	return str; }

}
