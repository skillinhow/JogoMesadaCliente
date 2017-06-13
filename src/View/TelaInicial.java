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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pbl2cliente.*;

/**Classe que define elementos da tela inicial
 *
 * @author Lucas Cardoso e Emanuel Santana
 */
public class TelaInicial extends JFrame {

    private JPanel p1, p2, p3, p4, base;
    private JLabel ipl, nickl;
    private JTextField ip, nick;
    private JButton entrar, reconectar;
    private ControllerConexao control;

    /**
     * Método construtor da classe. Inicializa e define o local dos elementos.
     */
    public TelaInicial() {
        super("JOGO DA MESADA");

        control = new ControllerConexao();

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        base = new JPanel(new GridLayout(3, 2));
        ipl = new JLabel("IP do Servidor:   ");
        nickl = new JLabel("Nick: ");
        ip = new JTextField();
        nick = new JTextField();
        entrar = new JButton("Entrar");
        reconectar = new JButton("Reconectar");

        base.add(nickl);
        base.add(nick);
        base.add(ipl);
        base.add(ip);
        base.add(reconectar);
        base.add(entrar);

        ButtonHandller but = new ButtonHandller();

        entrar.addActionListener(but);

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

    /**
     * Classe Listener que estabelece e trata os eventos dos botões da tela
     */
    private class ButtonHandller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ("Entrar".equals(ae.getActionCommand())) {

                try {
                    Socket cli = control.conectar(ip.getText(), 50000);
//                    control.start();
                    int resp = control.contato(nick.getText());
                    if (resp == 1) {
                        TelaConfig tc = new TelaConfig(nick.getText(), control);
                        dispose();
                    } else if (resp == 2) {
                        TelaEspera te = new TelaEspera(nick.getText(), control);
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
