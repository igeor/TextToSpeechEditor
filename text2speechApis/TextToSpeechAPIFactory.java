package text2speechApis;

public class TextToSpeechAPIFactory {
		
	public TextToSpeechAPIFactory() {}
	
	
	public TextToSpeechAPI createTTSAP(String str) {
		TextToSpeechAPI ttsAPI;
		if(str.equals("FreeTTSAdapter")) {
			ttsAPI = new FreeTTSAdapter();
		}else {
			ttsAPI = new FakeTextToSpeechAPI();
		}
		return ttsAPI;
	}
}
