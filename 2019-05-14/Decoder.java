package textexHTML;

/**
 * in dieser Klasse stehen Methoden, mit welchen Sonderzeichen des reinen Textes des HTML-Dokuments in ASCII-Zeichen konvertiert werden
 * @author ysf, fra
 *
 */
public class Decoder {
	
	public Decoder() {
		
	}
	
	/**
	 * getter f�r den Text mit Sonderzeichen in ASCII-Format
	 * @return String
	 */
	public String getNormText(String text) {
		String s = text ;   
		s = s.replace("&auml;", "�");
		s = s.replace("&Auml;", "�");
		s = s.replace("&ouml;", "�");
		s = s.replace("&Ouml;", "�");
		s = s.replace("&uuml;", "�");
		s = s.replace("&Uuml;", "�");
		s = s.replace("&szlig;", "ss");
		s = s.replace("&lt;", "<");
		s = s.replace("&amp;", ">");
		s = s.replace("&amp;", "&");
		s = s.replace("&quot;", "''");
		s = s.replace("&nbsp;", " ");
		return s;
	}
}
