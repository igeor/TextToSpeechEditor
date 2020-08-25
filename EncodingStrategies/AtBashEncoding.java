package EncodingStrategies;

public class AtBashEncoding extends TemplateEncoding{

	@Override
	public char mapCharacter(char c) {
		
		
		c = Character.toUpperCase(c);
        if(Character.isLetter(c)){
        	int newChar = ('Z' - c) + 'A';
        	c = (char) newChar;
        	return Character.toLowerCase(c);
        }
        
        return Character.toLowerCase(c);
        
	}

}
