package controle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import classes.SabreLuz;

public class ControleSabreLuz {

    private SabreLuz sabreLuz;

    public ControleSabreLuz(SabreLuz SabreLuz) {
        this.sabreLuz = SabreLuz;
    }

    public void salvarSabreLuz(String dados) {
        String[] dadosSabreLuz = dados.split(",");
        this.sabreLuz.setCor(dadosSabreLuz[0]);
        if (dadosSabreLuz[1].equals("true")) {
            this.sabreLuz.abrir();
        } else {
            this.sabreLuz.fechar();
        }
    }

    public void escreverArquivoSabreLuz() throws IOException {
        String dados;
        dados = this.sabreLuz.getCor() + "," +
                this.sabreLuz.isAberto();

        File arquivo = new File("C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\jediGrafico\\dados\\sabreluz.csv");
        if (!arquivo.exists()) {
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("CorSabreLuz, aberto");
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

    public void lerArquivoSabreLuz() throws IOException {
        File arquivo = new File("C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\App\\data\\sabreluz.csv");
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
