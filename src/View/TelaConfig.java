/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pbl2cliente.ConexaoCliente;

/**
 *
 * @author thelu
 */
public class TelaConfig extends JFrame {

    private JPanel p1, p2, p3, p4, p5, base;
    private JLabel nplayl, templ;
    private JTextField temp;
    private JComboBox nplay;
    private JButton iniciar;
    private ConexaoCliente controle;
    private String nick;

    public TelaConfig(String nick, ConexaoCliente controle) {
        super("JOGO DA MESADA");

        this.controle = controle;
        this.nick = nick;

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        base = new JPanel(new GridLayout(3, 2));
        nplayl = new JLabel("<html>Quantidade <br> de Jogadores:</html>");
        templ = new JLabel("Tempo de jogo: ");
        String[] qtd = {"2", "3", "4", "5", "6"};
        nplay = new JComboBox(qtd);
        temp = new JTextField();
        iniciar = new JButton("Iniciar");

        base.add(nplayl);
        base.add(nplay);

        base.add(templ);
        base.add(temp);
        base.add(p5);
        base.add(iniciar);
        
        ButtonHandller but = new ButtonHandller();
        
        iniciar.addActionListener(but);

        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.WEST);
        this.add(p4, BorderLayout.EAST);
        this.add(base, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private class ButtonHandller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ("Iniciar".equals(ae.getActionCommand())) {
                try {
                    String[] aux = controle.config(nick, ((String) nplay.getSelectedItem()), temp.getText());
                    
                    if ("H".equals(aux[0])) {
                        TelaEspera te = new TelaEspera(controle);
                        te.setVisible(true);
                        dispose();
                    }
                } catch (IOException ex) {
                    System.out.println("Erro na conexão");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro no casting");
                }
            }
        }

    }

    public static void main(String[] args) {
        
    }
}
