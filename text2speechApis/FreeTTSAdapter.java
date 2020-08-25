package text2speechApis;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;


public class FreeTTSAdapter implements TextToSpeechAPI{

	private Voice voice;
	private String str;
	private int volume,pitch,rate;

	public FreeTTSAdapter() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voice = VoiceManager.getInstance().getVoice("kevin16");
		
		setVolume(90);
		setRate(120);
		setPitch(120);
	}
	
	
	@Override
	public void play(String str) {
		if(voice != null) {
			voice.allocate();
			try {
				voice.speak(str);
				this.str = str;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void setVolume(int volume) {
		if(voice != null) {
			voice.allocate();
			try {
				voice.setVolume((float)volume/100);
				this.volume = volume;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setPitch(int pitch) {
		if(voice != null) {
			voice.allocate();
			try {
				voice.setPitch(pitch);
				this.pitch = pitch;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void setRate(int rate) {
		if(voice != null) {
			voice.allocate();
			try {
				voice.setRate(rate);
				this.rate = rate;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public String getPlayed() {
		return this.str;
	}


	@Override
	public int getVolume() {
		return this.volume;
	}


	@Override
	public int getPitch() {
		return this.pitch;
	}


	@Override
	public int getRate() {
		return this.rate;
	}


}
