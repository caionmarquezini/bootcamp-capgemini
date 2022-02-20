package senha;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class senha {

	public static void main(String... Args) {
		String senha = JOptionPane.showInputDialog("Informe a senha");

		int senha_fraca = ChecaSenha(senha);
		if (senha_fraca == 0)
			JOptionPane.showMessageDialog(null, "senha forte");
		else
			JOptionPane.showMessageDialog(null, "senha fraca, necessário mais " + senha_fraca + " digitos");
	}

	
	
	
	/*
	 * Função para chechar senha forte
	 * <p>
	 * Essa função utiliza regex para fazer a
	 * checagem do padrão da senha.
	 * </p>
	 * @param Senha
	 * @return Integer de quantos caracteres são necessários
	 */
	private static int ChecaSenha(String senha) {
		
		int senha_fraca = 0;
		if (!Pattern.matches("(.*\\d.*)", senha)) senha_fraca++;
		if (!Pattern.matches("(.*[a-z].*)", senha)) senha_fraca++;
		if (!Pattern.matches("(.*[A-Z].*)", senha)) senha_fraca++;
		if (!Pattern.matches("(.*\\W.*)", senha)) senha_fraca++;
	
		return senha_fraca;
	}

}
