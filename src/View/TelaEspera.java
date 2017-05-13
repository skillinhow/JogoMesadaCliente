/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.Socket;
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

    public TelaEspera(ConexaoCliente controle) {
        super("JOGO DA MESADA");
        
        this.controle = controle;
        
        mensagem = new JLabel("Buscando partida... Por favor aguarde...");
        iniciar = new JButton("Iniciar Partida");
        p1 = new JPanel();
        p2 = new JPanel();
        
        
        this.add(p1, BorderLayout.WEST);
        this.add(p2, BorderLayout.EAST);
        this.add(mensagem, BorderLayout.CENTER);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void escut(){
        try {
            controle.escutar();
        } catch (IOException ex) {
            System.out.println("Erro de conexão");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro de Casting");
        }
    }
}
