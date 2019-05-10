package textexHTML;

import java.util.Scanner;
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
	//private Scanner e = new Scanner(System.in);
	private StringBuffer sb;
	private int kontrolle = 0;
	private char kleiner = '<';
	private char groesser = '>';
	private int open = 0;
	private int ab = 0;
	private int bis = 0;
	
	private static int close = 0;
	StringBuffer s = new StringBuffer (" abc<de<<><f>  >g>hi  j<klm>no<p>qrs<t><u>vwxyzhallllllo2345");
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
		//this.anzBereiche = b;
		this.ab = o;
		this.bis = c + 1;
		
		sb.delete(ab, bis);
		
	}
	
/**
 * getter für den Text selbst, ohne Tags
 * @return
 */
	public String getCleanText(StringBuffer textMTags) {
		for (int i = 0; i < textMTags.length(); i++) {
			
		System.out.print(textMTags.charAt(i));
		if(intStack.isEmpty()) {
			if (textMTags.charAt(i) == kleiner) {
				intStack.push(i);
				kontrolle ++;
				open = i;
			}
		}
		else {
			if (textMTags.charAt(i) == kleiner) {
			intStack.push(i);
			kontrolle ++;
			}
			if (textMTags.charAt(i) == groesser) {
				intStack.pop();
				kontrolle --;
				close = i;
				if (kontrolle == 0) {
					entferneTags(textMTags, open, close);
					System.out.println("\nDas sind die spezifischen Werte: open@ " + open + "; kontrolle@ "+ kontrolle + "; close@ " + close);
					i = open - 1;
				}
			}
		}
			
		
		}
		
		System.out.println("\nDas sind die spezifischen Werte: open@ " + open + "; kontrolle@ "+ kontrolle + "; close@ " + close);
		String out = sb.toString().trim();
		System.out.println(out);
		
		
		String text = "null";
		return text;
	}
	
	
}
