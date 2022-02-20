package escada;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class escada {

	/*
	 * Função fazer escada
	 * <p>
	 * Utilizada para escrever uma escada em um buffer
	 * </p>
	 * @param Qtd quantidade de pisos
	 * @return buffer escada
	 */
	private static List<String> fazerEscada(int qtd) {
		List<String> temporario = new ArrayList<String>();
		for (int i=1; i<=qtd; i++) {
			temporario.add(
					" ".repeat(qtd-i)+
					"*".repeat(i)
					);
		}
		return temporario;
	}
	
	
	public static void main(String... Args) {
		int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantas linhas precisa?"));
		
		List<String> temporario2 = fazerEscada(qtd);
		for (String string : temporario2) {
			System.out.println(string);
		}
	}
	
}
