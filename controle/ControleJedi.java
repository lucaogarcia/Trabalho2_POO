package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import classes.Jedi;

public class ControleJedi {

	private Jedi jedi;

	public ControleJedi(Jedi jedi) {
		this.jedi = jedi;
	}

	public void salvarJedi(String dados) {

		String[] dadosJedi = dados.split(",");
		this.jedi.setNome(dadosJedi[0]);
		this.jedi.setAltura(Float.parseFloat(dadosJedi[1]));
		this.jedi.setIdade(Integer.parseInt(dadosJedi[2]));
	}

	public void escreverArquivoJedi() throws IOException {
		String dados = "";
		dados = this.jedi.getNome() + "," +
				this.jedi.getAltura() + "," +
				this.jedi.getIdade();
		System.out.println(dados);

		File arquivo = new File("C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\jediGrafico\\dados\\jedi.csv");
		if (!arquivo.exists()) {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("nomeJedi, altura, idade");
			bw.newLine();
			bw.write(dados);
			bw.close();
			fw.close();
		} else {
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(dados);
			bw.close();
			fw.close();
		}

	}

	public void lerArquivoJedi() throws IOException {
		File arquivo = new File("C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\App\\data\\jedi.csv");
		if (!arquivo.exists()) {
			System.out.println("Arquivo não encontrado");
		} else {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			String linha = br.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
			br.close();
			fr.close();
		}
	}
}