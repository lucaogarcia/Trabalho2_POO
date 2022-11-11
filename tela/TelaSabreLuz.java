package tela;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;

import controle.ControleSabreLuz;
import classes.SabreLuz;

public class TelaSabreLuz extends JFrame {
    private JTextField cor = new JTextField();
    private JTextField aberto = new JTextField();

    public TelaSabreLuz() {
        this.setTitle("CADASTRO SABRE DE LUZ");
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getCampos(), BorderLayout.CENTER);
        this.getContentPane().add(getBotoes(), BorderLayout.PAGE_END);
        this.setSize(1280, 720);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JPanel getBotoes() {
        JPanel pnBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSair = new JButton("Sair");
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        pnBotoes.add(btnSair);
        pnBotoes.add(btnSalvar);
        pnBotoes.add(btnCancelar);

        btnSair.addActionListener(this::btnSairClick);
        btnSalvar.addActionListener(this::btnSalvarClick);
        btnCancelar.addActionListener(this::btnCancelarClick);

        return pnBotoes;
    }

    public void btnSairClick(ActionEvent e) {
        switch (JOptionPane.showConfirmDialog(this, "Você deseja sair?", "Confirmação", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.CANCEL_OPTION:
                break;

            case JOptionPane.OK_OPTION:
                this.dispose();
                break;

        }
    }

    public void btnSalvarClick(ActionEvent e) {
        ControleSabreLuz controleSabreLuz = new ControleSabreLuz(new SabreLuz());

        switch (JOptionPane.showConfirmDialog(this, "Você deseja salvar?", "Confirmação", JOptionPane.YES_NO_OPTION)) {
            case JOptionPane.NO_OPTION:
                break;

            case JOptionPane.YES_OPTION:
                String dados = cor.getText() + ',' + aberto.getText();
                controleSabreLuz.salvarSabreLuz(dados);
                try {
                    controleSabreLuz.escreverArquivoSabreLuz();
                } catch (Exception e1) {
                    // TODO: handle exception
                }

                break;
        }

    }

    public void btnCancelarClick(ActionEvent e) {
        this.cor.setText("");
        this.aberto.setText("");
    }

    public JPanel getCampos() {
        JPanel painelJedi = new JPanel(new GridLayout(5, 2));
        painelJedi.add(new JLabel(" "));
        painelJedi.add(new JLabel(" "));
        painelJedi.add(new JLabel("Cor:"));
        painelJedi.add(this.cor);
        painelJedi.add(new JLabel("Aberto?:"));
        painelJedi.add(this.aberto);
        return painelJedi;
    }

    public static void main(String[] args) throws IOException {
        new TelaSabreLuz();
    }
}
