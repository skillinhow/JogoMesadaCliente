/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import TesteCont.Cont2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author thelu
 */
public class TelaPrincipal extends JFrame {

    private JPanel principal, base, tabuleiro, menu, info, dado, players, blank;
    private JPanel start, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20;
    private JPanel c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, sorte;
    private JLabel saldo, divida, numDado, jogadores, j1, j2, j3, j4, j5, j6;
    private JButton emprestimo, lancarDado, correios, compras;
    private GridBagConstraints limit;
    private GridBagLayout layout;
    private Cont2 jog = new Cont2();

    public TelaPrincipal() {
        super("Jogo da Mesada");

        principal = new JPanel(new BorderLayout());
        menu = new JPanel(new GridLayout(5, 1));
        blank = new JPanel();
        base = new JPanel(new BorderLayout());
        tabuleiro = new JPanel();
        saldo = new JLabel("Saldo");
        divida = new JLabel("Divida");
        numDado = new JLabel("Num Dado");
        jogadores = new JLabel("Jogadores");
        j1 = new JLabel("Alyson");
        j2 = new JLabel("Camille");
        j3 = new JLabel("Emanuel");
        j4 = new JLabel("Felipe");
        j5 = new JLabel("Lucas");
        j6 = new JLabel("Marcelo");
        emprestimo = new JButton("Emprestimo");
        lancarDado = new JButton("Lançar dado");
        correios = new JButton("Correios");
        compras = new JButton("Compras e Entreterimento");
        limit = new GridBagConstraints();
        layout = new GridBagLayout();

        tabuleiro.setLayout(layout);

        criaMenu();
        criaTabuleiro();

        principal.add(new JLabel(new ImageIcon("src/images/logo.png")), BorderLayout.NORTH);
        principal.add(menu, BorderLayout.WEST);
        principal.add(tabuleiro, BorderLayout.CENTER);
        
        base.add(principal, BorderLayout.CENTER);
        
        this.add(base);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setVisible(true);

    }

    private void criaMenu() {
        
        info = new JPanel(new GridLayout(3, 0));
        info.add(saldo);
        info.add(divida);
        info.add(emprestimo);

        dado = new JPanel(new GridLayout(2,0));
        dado.add(numDado);
        dado.add(lancarDado, limit);

        players = new JPanel(new GridLayout(7, 0));
        players.add(jogadores);
        players.add(j1);
        players.add(j2);
        players.add(j3);
        players.add(j4);
        players.add(j5);
        players.add(j6);
        
        menu.add(blank);
        menu.add(info);
        menu.add(dado);
        menu.add(players);
        
    }

    private void criaTabuleiro() {

        //Start
        limit.gridx = 2;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        start = new JPanel();
        start.add(new JLabel(new ImageIcon("src/images/partida2.png")));
        start.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(start, limit);

        //Casa 1
        limit.gridx = 4;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c1 = new JPanel();
        c1.add(new JLabel(new ImageIcon("src/images/4.png")));
        c1.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c1, limit);

        //Casa 2
        limit.gridx = 6;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c2 = new JPanel();
        c2.add(new JLabel(new ImageIcon("src/images/premiio.png")));
        c2.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c2, limit);

        //Casa 3
        limit.gridx = 8;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c3 = new JPanel();
        c3.add(new JLabel(new ImageIcon("src/images/4.png")));
        c3.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c3, limit);

        //Casa 4
        limit.gridx = 10;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c4 = new JPanel();
        c4.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c4.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c4, limit);

        //Casa 5
        limit.gridx = 12;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c5 = new JPanel();
        c5.add(new JLabel(new ImageIcon("src/images/4.png")));
        c5.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c5, limit);

        //Casa 6
        limit.gridx = 14;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c6 = new JPanel();
        c6.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c6.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c6, limit);

        //Casa 7
        limit.gridx = 2;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c7 = new JPanel();
        c7.add(new JLabel(new ImageIcon("src/images/praia.png")));
        c7.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c7, limit);

        //Casa 8
        limit.gridx = 4;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c8 = new JPanel();
        c8.add(new JLabel(new ImageIcon("src/images/arrocha.png")));
        c8.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c8, limit);

        //Casa 9
        limit.gridx = 6;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c9 = new JPanel();
        c9.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c9.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c9, limit);

        //Casa 10
        limit.gridx = 8;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c10 = new JPanel();
        c10.add(new JLabel(new ImageIcon("src/images/niver.png")));
        c10.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c10, limit);

        //Casa 11
        limit.gridx = 10;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c11 = new JPanel();
        c11.add(new JLabel(new ImageIcon("src/images/4.png")));
        c11.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c11, limit);

        //Casa 12
        limit.gridx = 12;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c12 = new JPanel();
        c12.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c12.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c12, limit);

        //Casa 13
        limit.gridx = 14;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c13 = new JPanel();
        c13.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c13.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c13, limit);

        //Casa 14
        limit.gridx = 2;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c14 = new JPanel();
        c14.add(new JLabel(new ImageIcon("src/images/floresta.png")));
        c14.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c14, limit);

        //Casa 15
        limit.gridx = 4;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c15 = new JPanel();
        c15.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c15.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c15, limit);

        //Casa 16
        limit.gridx = 6;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c16 = new JPanel();
        c16.add(new JLabel(new ImageIcon("src/images/4.png")));
        c16.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c16, limit);

        //Casa 17
        limit.gridx = 8;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c17 = new JPanel();
        c17.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c17.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c17, limit);

        //Casa 18
        limit.gridx = 10;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c18 = new JPanel();
        c18.add(new JLabel(new ImageIcon("src/images/lanche.png")));
        c18.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c18, limit);

        //Casa 19
        limit.gridx = 12;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c19 = new JPanel();
        c19.add(new JLabel(new ImageIcon("src/images/4.png")));
        c19.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c19, limit);

        //Casa 20
        limit.gridx = 14;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c20 = new JPanel();
        c20.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c20.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c20, limit);
        
        //Casa 21
        limit.gridx = 2;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c21 = new JPanel();
        c21.add(new JLabel(new ImageIcon("src/images/negocio.png")));
        c21.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c21, limit);

        //Casa 22
        limit.gridx = 4;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c22 = new JPanel();
        c22.add(new JLabel(new ImageIcon("src/images/4.png")));
        c22.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c22, limit);

        //Casa 23
        limit.gridx = 6;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c23 = new JPanel();
        c23.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c23.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c23, limit);

        //Casa 24
        limit.gridx = 8;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c24 = new JPanel();
        c24.add(new JLabel(new ImageIcon("src/images/4.png")));
        c24.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c24, limit);

        //Casa 25
        limit.gridx = 10;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c25 = new JPanel();
        c25.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c25.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c25, limit);

        //Casa 26
        limit.gridx = 12;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c26 = new JPanel();
        c26.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c26.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c26, limit);

        //Casa 27
        limit.gridx = 14;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c27 = new JPanel();
        c27.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c27.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c27, limit);
        
        //Casa 28
        limit.gridx = 2;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c28 = new JPanel();
        c28.add(new JLabel(new ImageIcon("src/images/shop.png")));
        c28.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c28, limit);
        
        //Casa 39
        limit.gridx = 4;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c29 = new JPanel();
        c29.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c29.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c29, limit);
        
        //Casa 30
        limit.gridx = 6;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c30 = new JPanel();
        c30.add(new JLabel(new ImageIcon("src/images/maratona.png")));
        c30.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c30, limit);
        
        //Casa 31
        limit.gridx = 8;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c31 = new JPanel();
        c31.add(new JLabel(new ImageIcon("src/images/mesada.png")));
        c31.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c31, limit);
        
        //Sorte Grande
        limit.gridx = 14;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        sorte = new JPanel();
        sorte.add(new JLabel(new ImageIcon("src/images/sorte.png")));
        sorte.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(sorte, limit);
        
        BotaoEmprestimo bt = new BotaoEmprestimo();
        
        emprestimo.addActionListener(bt);
    }
    private class BotaoEmprestimo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int valor = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite "
                    + "o valor do emprestimo:(Apenas números)"))); 
            jog.emprestimo(valor);
            
        }
    
    }

//    public static void main(String[] args) {
//        TelaPrincipal x = new TelaPrincipal();
//    }

}