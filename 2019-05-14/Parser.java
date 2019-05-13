package textexHTML;

import java.util.Stack;

/**
 * in dieser Klasse befinden sich Methoden, mit welchen Tags der Form <...> aus einem Text (String) entfernt werden.
 * @author ysf, fra
 *
 */

public class Parser  {

/**
 * Attribute
 */
	private StringBuffer sb;
	private char kleiner = '<';
	private char groesser = '>';
	private int open = 0;
	private int ab = 0;
	private int bis = 0;
	private int kommentar = 0;
	private int kontrolle = 0;
	
	private static int close = 0;
	StringBuffer s = new StringBuffer (" abc<de<<><f>  >g>hi  j<klm>no<p>qrs<t> <u>v>>>>><w>xyzhallllllo2345");
	Stack<Integer> intStack = new Stack<Integer>();
	
	public Parser () {
		
	}

/**
 * dieser Methode wird der HTML-Text mit Tags mitgegeben, sie entfernt die Tags
 * @param mitTags
 * @return
 */
	public void entferneTags(StringBuffer stringB, int o, int c) {
		this.sb = stringB;
		this.ab = o;
		this.bis = c + 1;
		
		sb.delete(ab, bis);
		
	}
	
/**
 * Methode, mit der die Tags aus dem Text entfernt werden
 * @return
 */
	public String getCleanText(StringBuffer textMTags) {
		for (int i = 0; i < textMTags.length(); i++) {
		if(intStack.isEmpty()) {
			if (textMTags.charAt(i) == kleiner) {
				intStack.push(i);
				kontrolle ++;
				open = i;
				
				
			}
		}
		else {
			if (textMTags.charAt(i) == kleiner) {
				if (kommentar == 0) {
					intStack.push(i);
					kontrolle ++;
				}
				if (textMTags.charAt(i + 1) == '!' && textMTags.charAt(i + 2) == '-' && textMTags.charAt(i + 3) == '-') {
					kommentar ++;
				}
			}
			if (textMTags.charAt(i) == groesser) {
				if (textMTags.charAt(i - 1) == '-' && textMTags.charAt(i - 2) == '-') {
					kommentar --;
				}
				
				
				
				if (kommentar == 0) {
					intStack.pop();
					kontrolle --;
					close = i;
				}
				
				
				if (kontrolle == 0) {
					entferneTags(textMTags, open, close);
					i = open - 1;
				}
			}
		}
		}
		
		//System.out.println("\nDas sind die spezifischen Werte: open@ " + open + "; kontrolle@ "+ kontrolle + "; close@ " + close);
		String out = sb.toString().trim();
		//System.out.println(out);
		return out;
	}
	
	public StringBuffer entferneScriptStyle() {
		
		for (int i = 0; i < textMTags.length(); i++) {
			
		}
		if (textMTags.charAt(i + 1) == '!' && textMTags.charAt(i + 2) == '-' && textMTags.charAt(i + 3) == '-') {
			kommentar ++;
		}
		
		if (textMTags.charAt(i + 1) == '!' && textMTags.charAt(i + 2) == '-' && textMTags.charAt(i + 3) == '-') {
				kommentar ++;
			}
			if (textMTags.charAt(i + 1) == 's' && textMTags.charAt(i + 2) == 'c' && textMTags.charAt(i + 3) == 'r' && textMTags.charAt(i + 4) == 'i' && textMTags.charAt(i + 5) == 'p' && textMTags.charAt(i + 6) == 't') {
				
				//	textMTags.charAt(i + 1) == 's' && textMTags.charAt(i + 2) == 'c' && textMTags.charAt(i + 3) == 'r' && textMTags.charAt(i + 4) == 'i' && textMTags.charAt(i + 5) == 'p' && textMTags.charAt(i + 6) == 't') {
				System.out.println("i1: " + i); 
				int curr = i;
				do
				{
					 curr ++;
					 if (curr > 8 && textMTags.charAt(curr - 8) == '<' && textMTags.charAt(curr - 7) == '/' && textMTags.charAt(curr - 6) == 's' && textMTags.charAt(curr - 5) == 'c' && textMTags.charAt(curr - 4) == 'r' && textMTags.charAt(curr - 3) == 'i' && textMTags.charAt(curr - 2) == 'p' && textMTags.charAt(curr - 1) == 't') {
							close = curr;
							entferneTags(textMTags, open, close);
							System.out.println(textMTags);
							System.out.println("i: " + i);
							intStack.pop();
							break;
						}
				} while (true);
			}
			if (textMTags.charAt(i + 1) == 's' && textMTags.charAt(i + 2) == 't' && textMTags.charAt(i + 3) == 'y' && textMTags.charAt(i + 4) == 'l' && textMTags.charAt(i + 5) == 'e') {
				int curr2 = i;
				do {
					curr2 ++;
					if (curr2 > 7 && textMTags.charAt(curr2 - 7) == '<' && textMTags.charAt(curr2 - 6) == '/' && textMTags.charAt(curr2 - 5) == 's' && textMTags.charAt(curr2 - 4) == 't' && textMTags.charAt(curr2 - 3) == 'y' && textMTags.charAt(curr2 - 2) == 'l' && textMTags.charAt(curr2 - 1) == 'e') {
						close = curr2;
						entferneTags(textMTags, open, close);
						intStack.pop();
						break;
					}
				} while (true);
				
			}
	}
}
