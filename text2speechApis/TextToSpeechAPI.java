package text2speechApis;

public interface TextToSpeechAPI {
	
	public void play(String str);
	public void setVolume(int volume);
	public void setPitch(int pitch);
	public void setRate(int rate);
	
	public String getPlayed();
	public int getVolume();
	public int getPitch();
	public int getRate();
	
}
