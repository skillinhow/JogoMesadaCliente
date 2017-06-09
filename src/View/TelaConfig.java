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
import pbl2cliente.ControllerConexao;

/**
 *
 * @author thelu
 */
public class TelaConfig extends JFrame {

    private JPanel p1, p2, p3, p4, p5, base;
    private JLabel nplayl, templ;
    private JComboBox nplay, temp;
    private JButton iniciar;
    private String nick;
    private String ip;
    private ControllerConexao cont;

    public TelaConfig(String nick, ControllerConexao control) {
        super("JOGO DA MESADA");

        this.nick = nick;
        cont = control;

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
        String[] qtd2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        temp = new JComboBox(qtd2);
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
                    int resp = cont.config(nplay.getSelectedItem().toString(), temp.getSelectedItem().toString(), nick);
                    if (resp == 2) {
                        System.out.println("Aguarde");
                        TelaEspera te = new TelaEspera(nick, cont);
                        dispose();
                    }
                } catch (IOException ex) {
                    System.out.println("Erro na abertura do Socket");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro de Casting");
                }
            }
        }

    }

}
