import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
import java.io.*;

import tela.*;

public class Menu extends JFrame {
    
    public Menu() {
        this.setTitle("Menu");
        this.getContentPane().setLayout(new BorderLayout());   
        this.getContentPane().add(getMenu(), BorderLayout.BEFORE_FIRST_LINE);
        this.add(imagem());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JMenuBar getMenu() {
        // Criação dos objetos do menu GUI
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_U);
        menu.getAccessibleContext().setAccessibleDescription("Este menu possui itens");
        menuBar.add(menu);

        // um grupo JMenuItems

        menuItem = new JMenuItem("Jedi", KeyEvent.VK_J);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Acessa jedi");
        menu.add(menuItem);

        // TELA JEDI - ABRIR
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaJedi();
            }
        });

        // TELA HABILIDADE
        menuItem = new JMenuItem("Habilidade");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(menuItem);

        // TELA HABILIDADE - ABRIR
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaHabilidade();
            }
        });

        // TELA SABRE LUZ
        menuItem = new JMenuItem("Sabre de Luz");
        menuItem.setMnemonic(KeyEvent.VK_L);
        menu.add(menuItem);

        // TELA SABRE LUZ - ABRIR
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaSabreLuz();
            }
        });

        // Item SAIR
        menuItem = new JMenuItem("Sair");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menu.add(menuItem);

        // ACTION DE SAIR

        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sairEvento();
            }
        });

        menuBar.add(menu);

        return menuBar;
    }

    public JLabel imagem(){
        ImageIcon imagem = new ImageIcon("jedi.jpg");
        JLabel label = new JLabel("", imagem, JLabel.CENTER);
        label.setSize(getPreferredSize());
        label.setLayout(null);
        
        return label;
    }

    

    public void sairEvento() {
        int sair = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\lucas\\OneDrive\\Área de Trabalho\\jediGrafico\\dados";
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        new Menu();
    }
}
