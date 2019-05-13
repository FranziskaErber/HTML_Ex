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
	 * getter für den Text mit Sonderzeichen in ASCII-Format
	 * @return String
	 */
	public String getNormText(String text) {
		String s = text ;   
		s = s.replace("&auml;", "ä");
		s = s.replace("&Auml;", "Ä");
		s = s.replace("&ouml;", "ö");
		s = s.replace("&Ouml;", "Ö");
		s = s.replace("&uuml;", "ü");
		s = s.replace("&Uuml;", "Ü");
		s = s.replace("&szlig;", "ss");
		s = s.replace("&lt;", "<");
		s = s.replace("&amp;", ">");
		s = s.replace("&amp;", "&");
		s = s.replace("&quot;", "''");
		s = s.replace("&nbsp;", " ");
		return s;
	}
}
