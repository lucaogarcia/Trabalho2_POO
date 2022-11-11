package classes;

public class SabreLuz {
    private String cor;
    private boolean aberto;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isAberto() {
        return aberto;
    }

    private void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public void abrir() {
        this.setAberto(true);
    }

    public void fechar() {
        this.setAberto(false);
    }

    @Override
    public String toString() {
        return "Cor do sabre: " + cor;
    }
}