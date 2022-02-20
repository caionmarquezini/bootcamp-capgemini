package anagrama;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class dicionario {

	private List<String[]> dict;
	private int charindex = 97;
	private Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
			89, 97, 101, 103, 107 };

	dicionario() {
	}

	/*
	 * função de hash numero primo1 <p> primeira função de hash, porém só funciona
	 * para alguns numeros </p>
	 * 
	 * @param primo numero a ser hasheado
	 * 
	 * @return hash
	 */
	private long prime(int primo) {
		return (long) (Math.pow(primo, 2) + primo + 42);
	}

	/*
	 * função de hash numero primo2 <p> segunda função de hash, porém só é ótima
	 * para numeros grandes, sendo necessária a função primo1 </p>
	 * 
	 * @param primo numero a ser hasheado
	 * 
	 * @return hash
	 */
	private long prime2(int primo) {
		long l1 = Long.parseLong("43142746595714191");
		long l2 = Long.parseLong("5283234035979900");
		return l1 + l2 * primo;
	}

	/*
	 * função de hash numero primo3 <p> terceira função de hash, para ter certeza
	 * </p>
	 * 
	 * @param primo numero a ser computado
	 * 
	 * @return hash
	 */
	private long prime3(int primo) {
		if ((primo < 28) && (primo > -1))
			return (long) primes[primo];
		return 0;
	}

	/*
	 * função para abrir dicionario csv <p> função que abre um arquivo .csv e traz
	 * para a memória seu conteudo. </p>
	 * 
	 * @param file nome do arquivo .csv
	 * 
	 * @return Lista contendo dicionario
	 */
	public void loadDict(String file) throws FileNotFoundException, IOException, CsvException {
		try (CSVReader reader = new CSVReader(new FileReader(file))) {
			dict = reader.readAll();
		}
	}

	/*
	 * função de hash1 <p> utiliza a função prime para gerar um hash que será
	 * utilizada pela aplicação </p>
	 * 
	 * @param word palavra a ser hasheada
	 * 
	 * @return long soma dos hashs da palavra
	 */
	private long word_to_prod(char[] word) {
		long tmp = 0;
		for (int i = 0; i < word.length; i++) {
			tmp += prime(((int) word[i]) - charindex);
		}
		return tmp;
	}

	/*
	 * função de hash2 <p> utiliza a função prime2 para gerar um hash que será
	 * utilizada pela aplicação </p>
	 * 
	 * @param word palavra a ser hasheada
	 * 
	 * @return long soma dos hashs da palavra
	 */
	private long word_to_prod2(char[] word) {
		long tmp = 0;
		for (int i = 0; i < word.length; i++) {
			tmp += prime2(((int) word[i]) - charindex);
		}
		return tmp;
	}

	/*
	 * função de hash2 <p> utiliza a função prime2 para gerar um hash que será
	 * utilizada pela aplicação </p>
	 * 
	 * @param word palavra a ser hasheada
	 * 
	 * @return long soma dos hashs da palavra
	 */
	private long word_to_prod3(char[] word) {
		long tmp = 0;
		for (int i = 0; i < word.length; i++) {
			tmp += prime3(((int) word[i]) - charindex);
		}
		return tmp;
	}

	/*
	 * Sanitização de input do usuário
	 * 
	 * @param word palavra
	 * 
	 * @return string palavra
	 */
	private char[] sanitize(String word) {
		return word.replace(" ", "").toLowerCase().toCharArray();
	}

	/*
	 * Função FindAnagram encontra um anagrama <p> encontra um anagrama no
	 * dicionario de portugues pt-br, fazendo um loop na lista de palavras e fazendo
	 * comparações entre o hash gerado pelo dicionário e a palavra na memória </p>
	 * 
	 * @param String word palavra a ser procurada
	 * 
	 * @return List lista de resultados, caso nula não há anagrama
	 */
	public List<String> FindAnagram(String word) {
		long tmp1 = word_to_prod(sanitize(word));
		long tmp2 = word_to_prod2(sanitize(word));
		long tmp3 = word_to_prod3(sanitize(word));
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < dict.size(); i++) {
			if (word_to_prod(dict.get(i)[0].toCharArray()) == tmp1) {
				if (word_to_prod2(dict.get(i)[0].toCharArray()) == tmp2) {
					if (word_to_prod3(dict.get(i)[0].toCharArray()) == tmp3) {
						if (word != dict.get(i)[0]) {
							result.add(dict.get(i)[0]);
						}
					}
				}
			}
		}
		return result;
	}
}
