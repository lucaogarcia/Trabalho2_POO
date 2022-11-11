package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import classes.Habilidade;

public class ControleHabilidade {
    private Habilidade habilidade;

    public ControleHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }

    public void salvarHabilidade(String dados) {

        String[] dadosHabilidade = dados.split(",");
        this.habilidade.setNome(dadosHabilidade[0]);
        this.habilidade.setValor(Integer.parseInt(dadosHabilidade[1]));
    }

    public void escreverArquivoHabilidade() throws IOException {
        String dados;
        dados = this.habilidade.getNome() + "," +
                this.habilidade.getValor();

        File arquivo = new File("C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\jediGrafico\\dados\\habilidade.csv");
        if (!arquivo.exists()) {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("nomeHabilidade, valorHabilidade");
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

    public void lerArquivoHabilidade() throws IOException {
        File arquivo = new File("C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\App\\data\\habilidade.csv");
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
