/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pbl2cliente.ConexaoCliente;

/**
 *
 * @author thelu
 */
public class TelaEspera extends JFrame {

    private JLabel mensagem, pacote;
    private JPanel p1, p2;
    private ConexaoCliente controle;
    private JButton iniciar;
    private String nick;

    public TelaEspera(ConexaoCliente controle, String nick) {
        super("JOGO DA MESADA");

        this.controle = controle;
        this.nick = nick;

        mensagem = new JLabel("Buscando partida... Por favor aguarde...");
        iniciar = new JButton("Iniciar Partida");
        p1 = new JPanel();
        p2 = new JPanel();

        iniciar.setVisible(true);

        ButtonHandler x = new ButtonHandler();

        iniciar.addActionListener(x);

        this.setLayout(new GridLayout(2, 1));
        this.add(mensagem);
        this.add(iniciar);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ("Iniciar Partida".equals(ae.getActionCommand())) {
                try {
                    boolean pronto = controle.partidaPronta(nick);
                } catch (IOException ex) {
                    Logger.getLogger(TelaEspera.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaEspera.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TelaEspera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void setIniciar(boolean iniciar) {
        this.iniciar.setVisible(iniciar);
    }

}
