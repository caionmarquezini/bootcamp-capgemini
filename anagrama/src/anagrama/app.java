package anagrama;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import com.opencsv.exceptions.CsvException;

public class app {
	
	public static void main(String... Args) throws FileNotFoundException, IOException, CsvException {
		
	dicionario dict = new dicionario();
	dict.loadDict("dict.csv");
		
	String word = JOptionPane.showInputDialog("palavra");
	List<String> resultado = dict.FindAnagram(word);
	if (resultado.size() == 0)
		JOptionPane.showMessageDialog(null, "não há anagrama para "+word);
	else
		JOptionPane.showMessageDialog(null, "anagramas para "+word+":\n"+resultado.toString());
	}
	
	
}
