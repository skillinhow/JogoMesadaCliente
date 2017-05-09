/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author thelu
 */
public class TelaPrincipal extends JFrame {
    
    private JPanel principal;
    private JLabel saldo, divida, numDado;
    private JButton emprestimo, lancarDado, correios, compras;
    private GridBagConstraints limit;
    private GridBagLayout layout;

    public TelaPrincipal() {
        super("Jogo da Mesada");
        
        principal = new JPanel();
        saldo = new JLabel("Saldo");
        divida = new JLabel("Divida");
        numDado = new JLabel("Num Dado");
        emprestimo = new JButton("Emprestimo");
        lancarDado = new JButton("Lançar dado");
        correios = new JButton("Correios");
        compras = new JButton("Compras e Entreterimento");
        limit = new GridBagConstraints();
        layout = new GridBagLayout();
        
        

    }

    public static void main(String[] args) {
        TelaPrincipal x = new TelaPrincipal();
    }

}
