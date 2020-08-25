package EncodingStrategies;

public class StrategiesFactory {
	
	
	public EncodingStrategy createStrategy(String strategy) {
		if(strategy.equals("Rot13Encoding")) {
			Rot13Encoding rot13Enc = new Rot13Encoding();
			return rot13Enc;
		}else {
			AtBashEncoding atBashEnc = new AtBashEncoding();
			return atBashEnc;
		}
	}
	
}
