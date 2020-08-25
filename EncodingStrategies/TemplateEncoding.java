package EncodingStrategies;

public abstract class TemplateEncoding implements EncodingStrategy{
	
	private StringBuilder str;
	
	public String encode(String str) {
		
		this.str  = new StringBuilder(str);
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			c = mapCharacter(c);
			this.str.setCharAt(i, c);
		}
		str = this.str.toString();
		return str;
	}
	
	public abstract char mapCharacter(char c);
		
	
}
