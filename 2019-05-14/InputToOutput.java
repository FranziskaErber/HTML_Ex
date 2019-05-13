package textexHTML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * In dieser Klasse stehen Methoden, in welchen der HTML-Text geladen, verarbeitet und ausgegeben wird
 * @author ysf, fra
 *
 */
public class InputToOutput {

	StringBuffer sb = new StringBuffer();
	
	public InputToOutput() {
		
	}
	
	/**
	 * Methode, um den html-Text zu laden
	 * @throws IOException 
	 */
	public String loadText(  ) throws IOException {
		File file = new File("C:\\Users\\chef\\Desktop\\OOP_Files\\Youtube.html");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st ,s = ""; 
		while ((st = br.readLine()) != null) 
		  {
			 s = s +"\n" + st ;
		  }
		return s;
	}
	
	/**
	 * 2
	 * Methode, um den Text ohne Tags und mit ASCII auszugeben
	 * speichern als Textdatei
	 */
	public void speichern(String str) throws IOException 
	{
		FileWriter file = new FileWriter("C:\\Users\\chef\\Desktop\\OOP_Files\\output.txt");
		BufferedWriter writer = new BufferedWriter(file);
		writer.write(str);
		writer.close();
		
	}
	
	public void textExtraktion() throws IOException {
		//InputtoOutout i = new InputtoOutout();
		Decoder d = new Decoder();
		Parser p = new Parser();
		String finale ;
		String text = loadText() ;
		StringBuffer sb = new StringBuffer (text);
		finale = d.getNormText(p.getCleanText(sb));
		System.out.println(finale);
		//bzw.
		speichern(finale);
	}
}
