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
import pbl2cliente.ControllerConexao;

/**Classe que define os elementos da tela de espera
 *
 * @author Lucas Cardoso e Emanuel Santana
 */
public class TelaEspera extends JFrame {

    private JLabel mensagem, pacote;
    private JPanel p1, p2;
    private JButton iniciar;
    private String nick;
    private ControllerConexao cont;

    /** Construtor da classe. 
     * 
     * @param nick Recebe o nick do jogador
     * @param control Recebe um objeto do tipo ControllerConexão para ações de controle
     */
    public TelaEspera(String nick, ControllerConexao control) {
        super("JOGO DA MESADA");

        this.nick = nick;
        this.cont = control;

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

    /**
     * Classe Listener que estabelece e trata os eventos dos botões da tela
     */
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if ("Iniciar Partida".equals(ae.getActionCommand())) {
                int resp = 0;
                do {
                    try {
                        resp = cont.espera();
                    } catch (IOException ex) {
                        System.out.println("Erro na abertura do Socket");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Erro de Casting");
                    }
                } while (resp != 4);
                if (resp == 4) {
                    TelaPrincipal tp = new TelaPrincipal(cont);
                    dispose();
                }
            }
        }

    }


}
