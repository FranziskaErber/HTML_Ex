package textexHTML;

import java.util.Iterator;

public class TextIterator implements Iterator <Character>{
	
	StringBuffer text = new StringBuffer();
	//String text;
	private int positionImText = 0;
	
	public TextIterator() {
		
	}

/**
 * gemoppst von Preussner-Uebung
 * @return
 */
	@Override
	public Character next() {
		return Character.valueOf(this.text.charAt(positionImText));
	}

	@Override
	public boolean hasNext() {
		return positionImText < text.length() - 1;
	}

	

}
