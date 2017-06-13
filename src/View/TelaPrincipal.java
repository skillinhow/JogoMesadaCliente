/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.ComprasEnt;
import TesteCont.Cont;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pbl2cliente.ControllerConexao;
import pbl2cliente.Jogadores;

/**Classe que define componentes da tela principal
 *
 * @author Lucas Cardoso e Emanuel Santana
 */
public class TelaPrincipal extends JFrame {

    private JPanel principal, base, tabuleiro, menu, info, dado, players, blank;
    private JPanel start, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20;
    private JPanel c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, sorte, vac, x4;
    private JLabel saldo, divida, numDado, jogadores, j1, j2, j3, j4, j5, j6;
    private JButton emprestimo, lancarDado, correios, compras, encerra;
    private GridBagConstraints limit, limit2;
    private GridBagLayout layout;
    private Cont contro;
    private Stack<ComprasEnt> cartaEnt = new Stack();
    private ControllerConexao control;
    

    /**
     * Construtor da classe.
     * Define e inicializa todos os elementos da interface colocando-os nos devidos lugars.
     * @param x Recebe um objeto do tipo Controller
     */
    public TelaPrincipal(ControllerConexao x) {
        super("Jogo da Mesada");

        this.control = x;
        
        contro = new Cont(control);
        contro.start();
        principal = new JPanel(new BorderLayout());
        menu = new JPanel(new GridLayout(5, 1));
        blank = new JPanel();
        base = new JPanel(new BorderLayout());
        tabuleiro = new JPanel();
        vac = new JPanel(new GridLayout(3, 2));
        saldo = new JLabel("Saldo");
        divida = new JLabel("Divida");
        numDado = new JLabel("Num Dado: ");
        jogadores = new JLabel("Jogadores");
        for(int i = 0; i<x.listaJogadores().size(); i++){
            String auxdn;
           auxdn = ((Jogadores)x.listaJogadores().get(i)).getNick();
           if(i == 0){
               j1 = new JLabel(auxdn);
           }
           else if(i == 1){
               j2 = new JLabel(auxdn);
           }
           else if(i == 2){
               j3 = new JLabel(auxdn);
           }
           else if(i == 3){
               j4 = new JLabel(auxdn);
           }
           else if(i == 4){
               j5 = new JLabel(auxdn);
           }
           else if(i == 5){
               j6 = new JLabel(auxdn);
           }
          
        }
        if(control.listaJogadores().size() == 2){
            j3 = new JLabel("");
        j4 = new JLabel("");
        j5 = new JLabel("");
        j6 = new JLabel("");
        }
        else if(control.listaJogadores().size() == 3){
        j4 = new JLabel("");       
        j5 = new JLabel("");
        j6 = new JLabel("");
        }
         else if(control.listaJogadores().size() == 4){             
        j5 = new JLabel("");
        j6 = new JLabel("");
        }        
         else if(control.listaJogadores().size() == 5){                 
        j6 = new JLabel("");
         }
        emprestimo = new JButton("Emprestimo");
        lancarDado = new JButton("Lançar dado");
        correios = new JButton("Correios");
        compras = new JButton("Compras e Entreterimento");
        limit = new GridBagConstraints();
        limit2 = new GridBagConstraints();
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
        this.setSize(800, 600);
        this.setVisible(true);

    }

    /**
     * Método auxiliar que cria de forma simplificada um menu e adiciona na interface principal
     */
    private void criaMenu() {

        info = new JPanel(new GridLayout(3, 0));
        info.add(saldo);
        info.add(divida);
        info.add(emprestimo);

        dado = new JPanel(new GridLayout(2, 0));
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

    /**
     * Método auxiliar que inicializa e coloca os elementos do tabuleiro nos seus respectivos lugares
     */
    private void criaTabuleiro() {

        //Start
        limit.gridx = 2;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        start = new JPanel(new GridBagLayout());
        JPanel a = new JPanel();
        a.setBackground(Color.red);
        JPanel b = new JPanel();
        b.setBackground(Color.black);
        JPanel c = new JPanel();
        c.setBackground(Color.blue);
        JPanel d = new JPanel();
        d.setBackground(Color.gray);
        JPanel e = new JPanel();
        e.setBackground(Color.green);
        JPanel f = new JPanel();
        f.setBackground(Color.yellow);
        JPanel g = new JPanel();
        g.setBackground(Color.pink);
        JPanel h = new JPanel();
        h.setBackground(Color.orange);
        limit2.gridx = 0;
        limit2.gridy = 0;

        start.add(a, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        start.add(b, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        start.add(c, limit2);

        start.add(a, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        start.add(b, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        start.add(c, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        start.add((new JLabel(new ImageIcon("src/images/partida2.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        start.add(d, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        start.add(e, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        start.add(f, limit2);

        start.add(d, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        start.add(e, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        start.add(f, limit2);
        start.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(start, limit);

        //Casa 1
        limit.gridx = 4;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;

        c1 = new JPanel(new GridBagLayout());

        c1 = new JPanel(new GridBagLayout());

        JPanel aa = new JPanel();
        aa.setBackground(Color.red);
        JPanel bb = new JPanel();
        bb.setBackground(Color.black);
        JPanel cc = new JPanel();
        cc.setBackground(Color.blue);
        JPanel dd = new JPanel();
        dd.setBackground(Color.gray);
        JPanel ee = new JPanel();
        ee.setBackground(Color.green);
        JPanel ff = new JPanel();
        ff.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c1.add(aa, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c1.add(bb, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c1.add(cc, limit2);

        c1.add(aa, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c1.add(bb, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c1.add(cc, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c1.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c1.add(dd, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c1.add(ee, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c1.add(ff, limit2);

        c1.add(dd, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c1.add(ee, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c1.add(ff, limit2);

        c1.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c1, limit);

        //Casa 2
        limit.gridx = 6;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c2 = new JPanel(new GridBagLayout());
        JPanel aaa = new JPanel();
        aaa.setBackground(Color.red);
        JPanel bbb = new JPanel();
        bbb.setBackground(Color.black);
        JPanel ccc = new JPanel();
        ccc.setBackground(Color.blue);
        JPanel ddd = new JPanel();
        ddd.setBackground(Color.gray);
        JPanel eee = new JPanel();
        eee.setBackground(Color.green);
        JPanel fff = new JPanel();
        fff.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c2.add(aaa, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c2.add(bbb, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c2.add(ccc, limit2);

        c2.add(aaa, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c2.add(bbb, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c2.add(ccc, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c2.add((new JLabel(new ImageIcon("src/images/premiio.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c2.add(ddd, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c2.add(eee, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c2.add(fff, limit2);

        c2.add(ddd, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c2.add(eee, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c2.add(fff, limit2);

        c2.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c2, limit);

        //Casa 3
        limit.gridx = 8;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c3 = new JPanel(new GridBagLayout());
        JPanel a1 = new JPanel();
        a1.setBackground(Color.red);
        JPanel b1 = new JPanel();
        b1.setBackground(Color.black);
        JPanel c1 = new JPanel();
        c1.setBackground(Color.blue);
        JPanel d1 = new JPanel();
        d1.setBackground(Color.gray);
        JPanel e1 = new JPanel();
        e1.setBackground(Color.green);
        JPanel f1 = new JPanel();
        f1.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c3.add(a1, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c3.add(b1, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c3.add(c1, limit2);

        c3.add(a1, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c3.add(b1, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c3.add(c1, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c3.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c3.add(d1, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c3.add(e1, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c3.add(f1, limit2);

        c3.add(d1, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c3.add(e1, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c3.add(f1, limit2);

        c3.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c3, limit);

        //Casa 4
        limit.gridx = 10;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c4 = new JPanel(new GridBagLayout());
        JPanel a2 = new JPanel();
        a2.setBackground(Color.red);
        JPanel b2 = new JPanel();
        b2.setBackground(Color.black);
        JPanel c2 = new JPanel();
        c2.setBackground(Color.blue);
        JPanel d2 = new JPanel();
        d2.setBackground(Color.gray);
        JPanel e2 = new JPanel();
        e2.setBackground(Color.green);
        JPanel f2 = new JPanel();
        f2.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c4.add(a2, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c4.add(b2, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c4.add(c2, limit2);

        c4.add(a2, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c4.add(b2, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c4.add(c2, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c4.add((new JLabel(new ImageIcon("src/images/compras.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c4.add(d2, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c4.add(e2, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c4.add(f2, limit2);

        c4.add(d2, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c4.add(e2, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c4.add(f2, limit2);

        c4.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c4, limit);

        //Casa 5
        limit.gridx = 12;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c5 = new JPanel(new GridBagLayout());
        JPanel a3 = new JPanel();
        a3.setBackground(Color.red);
        JPanel b3 = new JPanel();
        b3.setBackground(Color.black);
        JPanel c3 = new JPanel();
        c3.setBackground(Color.blue);
        JPanel d3 = new JPanel();
        d3.setBackground(Color.gray);
        JPanel e3 = new JPanel();
        e3.setBackground(Color.green);
        JPanel f3 = new JPanel();
        f3.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c5.add(a3, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c5.add(b3, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c5.add(c3, limit2);

        c5.add(a3, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c5.add(b3, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c5.add(c3, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c5.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c5.add(d3, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c5.add(e3, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c5.add(f3, limit2);

        c5.add(d3, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c5.add(e3, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c5.add(f3, limit2);

        c5.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c5, limit);

        //Casa 6
        limit.gridx = 14;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c6 = new JPanel(new GridBagLayout());
        JPanel a4 = new JPanel();
        a4.setBackground(Color.red);
        JPanel b4 = new JPanel();
        b4.setBackground(Color.black);
        JPanel c4 = new JPanel();
        c4.setBackground(Color.blue);
        JPanel d4 = new JPanel();
        d4.setBackground(Color.gray);
        JPanel e4 = new JPanel();
        e4.setBackground(Color.green);
        JPanel f4 = new JPanel();
        f4.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c6.add(a4, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c6.add(b4, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c6.add(c4, limit2);

        c6.add(a4, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c6.add(b4, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c6.add(c4, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c6.add((new JLabel(new ImageIcon("src/images/bolao.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c6.add(d4, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c6.add(e4, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c6.add(f4, limit2);

        c6.add(d4, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c6.add(e4, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c6.add(f4, limit2);

        c6.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c6, limit);

        //Casa 7
        limit.gridx = 2;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c7 = new JPanel(new GridBagLayout());
        JPanel a5 = new JPanel();
        a5.setBackground(Color.red);
        JPanel b5 = new JPanel();
        b5.setBackground(Color.black);
        JPanel c5 = new JPanel();
        c5.setBackground(Color.blue);
        JPanel d5 = new JPanel();
        d5.setBackground(Color.gray);
        JPanel e5 = new JPanel();
        e5.setBackground(Color.green);
        JPanel f5 = new JPanel();
        f5.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c7.add(a5, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c7.add(b5, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c7.add(c5, limit2);

        c7.add(a5, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c7.add(b5, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c7.add(c5, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c7.add((new JLabel(new ImageIcon("src/images/praia.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c7.add(d5, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c7.add(e5, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c7.add(f5, limit2);

        c7.add(d5, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c7.add(e5, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c7.add(f5, limit2);

        c7.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c7, limit);

        //Casa 8
        limit.gridx = 4;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c8 = new JPanel(new GridBagLayout());
        JPanel a6 = new JPanel();
        a6.setBackground(Color.red);
        JPanel b6 = new JPanel();
        b6.setBackground(Color.black);
        JPanel c6 = new JPanel();
        c6.setBackground(Color.blue);
        JPanel d6 = new JPanel();
        d6.setBackground(Color.gray);
        JPanel e6 = new JPanel();
        e6.setBackground(Color.green);
        JPanel f6 = new JPanel();
        f6.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c8.add(a6, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c8.add(b6, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c8.add(c6, limit2);

        c8.add(a6, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c8.add(b6, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c8.add(c6, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c8.add((new JLabel(new ImageIcon("src/images/arrocha.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c8.add(d6, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c8.add(e6, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c8.add(f6, limit2);

        c8.add(d6, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c8.add(e6, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c8.add(f6, limit2);

        c8.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c8, limit);

        //Casa 9
        limit.gridx = 6;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c9 = new JPanel(new GridBagLayout());
        JPanel a7 = new JPanel();
        a7.setBackground(Color.red);
        JPanel b7 = new JPanel();
        b7.setBackground(Color.black);
        JPanel c7 = new JPanel();
        c7.setBackground(Color.blue);
        JPanel d7 = new JPanel();
        d7.setBackground(Color.gray);
        JPanel e7 = new JPanel();
        e7.setBackground(Color.green);
        JPanel f7 = new JPanel();
        f7.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c9.add(a7, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c9.add(b7, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c9.add(c7, limit2);

        c9.add(a7, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c9.add(b7, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c9.add(c7, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c9.add((new JLabel(new ImageIcon("src/images/comprador.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c9.add(d7, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c9.add(e7, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c9.add(f7, limit2);

        c9.add(d7, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c9.add(e7, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c9.add(f7, limit2);

        c9.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c9, limit);

        //Casa 10
        limit.gridx = 8;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c10 = new JPanel(new GridBagLayout());
        JPanel a8 = new JPanel();
        a8.setBackground(Color.red);
        JPanel b8 = new JPanel();
        b8.setBackground(Color.black);
        JPanel c8 = new JPanel();
        c8.setBackground(Color.blue);
        JPanel d8 = new JPanel();
        d8.setBackground(Color.gray);
        JPanel e8 = new JPanel();
        e8.setBackground(Color.green);
        JPanel f8 = new JPanel();
        f8.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c10.add(a8, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c10.add(b8, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c10.add(c8, limit2);

        c10.add(a8, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c10.add(b8, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c10.add(c8, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c10.add((new JLabel(new ImageIcon("src/images/niver.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c10.add(d8, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c10.add(e8, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c10.add(f8, limit2);

        c10.add(d8, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c10.add(e8, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c10.add(f8, limit2);

        c10.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c10, limit);

        //Casa 11
        limit.gridx = 10;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c11 = new JPanel(new GridBagLayout());
        JPanel a9 = new JPanel();
        a9.setBackground(Color.red);
        JPanel b9 = new JPanel();
        b9.setBackground(Color.black);
        JPanel c9 = new JPanel();
        c9.setBackground(Color.blue);
        JPanel d9 = new JPanel();
        d9.setBackground(Color.gray);
        JPanel e9 = new JPanel();
        e9.setBackground(Color.green);
        JPanel f9 = new JPanel();
        f9.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c11.add(a9, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c11.add(b9, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c11.add(c9, limit2);

        c11.add(a9, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c11.add(b9, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c11.add(c9, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c11.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c11.add(d9, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c11.add(e9, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c11.add(f9, limit2);

        c11.add(d9, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c11.add(e9, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c11.add(f9, limit2);

        c11.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c11, limit);

        //Casa 12
        limit.gridx = 12;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c12 = new JPanel(new GridBagLayout());
        JPanel a10 = new JPanel();
        a10.setBackground(Color.red);
        JPanel b10 = new JPanel();
        b10.setBackground(Color.black);
        JPanel c10 = new JPanel();
        c10.setBackground(Color.blue);
        JPanel d10 = new JPanel();
        d10.setBackground(Color.gray);
        JPanel e10 = new JPanel();
        e10.setBackground(Color.green);
        JPanel f10 = new JPanel();
        f10.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c12.add(a10, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c12.add(b10, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c12.add(c10, limit2);

        c12.add(a10, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c12.add(b10, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c12.add(c10, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c12.add((new JLabel(new ImageIcon("src/images/compras.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c12.add(d10, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c12.add(e10, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c12.add(f10, limit2);

        c12.add(d10, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c12.add(e10, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c12.add(f10, limit2);

        c12.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c12, limit);

        //Casa 13
        limit.gridx = 14;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c13 = new JPanel(new GridBagLayout());
        JPanel a11 = new JPanel();
        a11.setBackground(Color.red);
        JPanel b11 = new JPanel();
        b11.setBackground(Color.black);
        JPanel c11 = new JPanel();
        c11.setBackground(Color.blue);
        JPanel d11 = new JPanel();
        d11.setBackground(Color.gray);
        JPanel e11 = new JPanel();
        e11.setBackground(Color.green);
        JPanel f11 = new JPanel();
        f11.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c13.add(a11, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c13.add(b11, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c13.add(c11, limit2);

        c13.add(a11, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c13.add(b11, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c13.add(c11, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c13.add((new JLabel(new ImageIcon("src/images/bolao.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c13.add(d11, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c13.add(e11, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c13.add(f11, limit2);

        c13.add(d11, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c13.add(e11, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c13.add(f11, limit2);

        c13.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c13, limit);

        //Casa 14
        limit.gridx = 2;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c14 = new JPanel(new GridBagLayout());
        JPanel a12 = new JPanel();
        a12.setBackground(Color.red);
        JPanel b12 = new JPanel();
        b12.setBackground(Color.black);
        JPanel c12 = new JPanel();
        c12.setBackground(Color.blue);
        JPanel d12 = new JPanel();
        d12.setBackground(Color.gray);
        JPanel e12 = new JPanel();
        e12.setBackground(Color.green);
        JPanel f12 = new JPanel();
        f12.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c14.add(a12, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c14.add(b12, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c14.add(c12, limit2);

        c14.add(a12, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c14.add(b12, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c14.add(c12, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c14.add((new JLabel(new ImageIcon("src/images/floresta.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c14.add(d12, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c14.add(e12, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c14.add(f12, limit2);

        c14.add(d12, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c14.add(e12, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c14.add(f12, limit2);

        c14.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c14, limit);

        //Casa 15
        limit.gridx = 4;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c15 = new JPanel(new GridBagLayout());
        JPanel a13 = new JPanel();
        a13.setBackground(Color.red);
        JPanel b13 = new JPanel();
        b13.setBackground(Color.black);
        JPanel c13 = new JPanel();
        c13.setBackground(Color.blue);
        JPanel d13 = new JPanel();
        d13.setBackground(Color.gray);
        JPanel e13 = new JPanel();
        e13.setBackground(Color.green);
        JPanel f13 = new JPanel();
        f13.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c15.add(a13, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c15.add(b13, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c15.add(c13, limit2);

        c15.add(a13, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c15.add(b13, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c15.add(c13, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c15.add((new JLabel(new ImageIcon("src/images/compras.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c15.add(d13, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c15.add(e13, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c15.add(f13, limit2);

        c15.add(d13, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c15.add(e13, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c15.add(f13, limit2);

        c15.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c15, limit);

        //Casa 16
        limit.gridx = 6;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c16 = new JPanel(new GridBagLayout());
        JPanel a14 = new JPanel();
        a14.setBackground(Color.red);
        JPanel b14 = new JPanel();
        b14.setBackground(Color.black);
        JPanel c14 = new JPanel();
        c14.setBackground(Color.blue);
        JPanel d14 = new JPanel();
        d14.setBackground(Color.gray);
        JPanel e14 = new JPanel();
        e14.setBackground(Color.green);
        JPanel f14 = new JPanel();
        f14.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c16.add(a14, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c16.add(b14, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c16.add(c14, limit2);

        c16.add(a14, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c16.add(b14, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c16.add(c14, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c16.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c16.add(d14, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c16.add(e14, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c16.add(f14, limit2);

        c16.add(d14, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c16.add(e14, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c16.add(f14, limit2);

        c16.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c16, limit);

        //Casa 17
        limit.gridx = 8;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c17 = new JPanel(new GridBagLayout());
        JPanel a15 = new JPanel();
        a15.setBackground(Color.red);
        JPanel b15 = new JPanel();
        b15.setBackground(Color.black);
        JPanel c15 = new JPanel();
        c15.setBackground(Color.blue);
        JPanel d15 = new JPanel();
        d15.setBackground(Color.gray);
        JPanel e15 = new JPanel();
        e15.setBackground(Color.green);
        JPanel f15 = new JPanel();
        f15.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c17.add(a15, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c17.add(b15, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c17.add(c15, limit2);

        c17.add(a15, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c17.add(b15, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c17.add(c15, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c17.add((new JLabel(new ImageIcon("src/images/comprador.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c17.add(d15, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c17.add(e15, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c17.add(f15, limit2);

        c17.add(d15, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c17.add(e15, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c17.add(f15, limit2);

        c17.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c17, limit);

        //Casa 18
        limit.gridx = 10;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c18 = new JPanel(new GridBagLayout());
        JPanel a16 = new JPanel();
        a16.setBackground(Color.red);
        JPanel b16 = new JPanel();
        b16.setBackground(Color.black);
        JPanel c16 = new JPanel();
        c16.setBackground(Color.blue);
        JPanel d16 = new JPanel();
        d16.setBackground(Color.gray);
        JPanel e16 = new JPanel();
        e16.setBackground(Color.green);
        JPanel f16 = new JPanel();
        f16.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c18.add(a16, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c18.add(b16, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c18.add(c16, limit2);

        c18.add(a16, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c18.add(b16, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c18.add(c16, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c18.add((new JLabel(new ImageIcon("src/images/lanche.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c18.add(d16, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c18.add(e16, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c18.add(f16, limit2);

        c18.add(d16, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c18.add(e16, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c18.add(f16, limit2);

        c18.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c18, limit);

        //Casa 19
        limit.gridx = 12;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c19 = new JPanel(new GridBagLayout());
        JPanel a17 = new JPanel();
        a17.setBackground(Color.red);
        JPanel b17 = new JPanel();
        b17.setBackground(Color.black);
        JPanel c17 = new JPanel();
        c17.setBackground(Color.blue);
        JPanel d17 = new JPanel();
        d17.setBackground(Color.gray);
        JPanel e17 = new JPanel();
        e17.setBackground(Color.green);
        JPanel f17 = new JPanel();
        f17.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c19.add(a17, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c19.add(b17, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c19.add(c17, limit2);

        c19.add(a17, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c19.add(b17, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c19.add(c17, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c19.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c19.add(d17, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c19.add(e17, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c19.add(f17, limit2);

        c19.add(d17, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c19.add(e17, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c19.add(f17, limit2);

        c19.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c19, limit);

        //Casa 20
        limit.gridx = 14;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c20 = new JPanel(new GridBagLayout());
        JPanel a18 = new JPanel();
        a18.setBackground(Color.red);
        JPanel b18 = new JPanel();
        b18.setBackground(Color.black);
        JPanel c18 = new JPanel();
        c18.setBackground(Color.blue);
        JPanel d18 = new JPanel();
        d18.setBackground(Color.gray);
        JPanel e18 = new JPanel();
        e18.setBackground(Color.green);
        JPanel f18 = new JPanel();
        f18.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c20.add(a18, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c20.add(b18, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c20.add(c18, limit2);

        c20.add(a18, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c20.add(b18, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c20.add(c18, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c20.add((new JLabel(new ImageIcon("src/images/bolao.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c20.add(d18, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c20.add(e18, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c20.add(f18, limit2);

        c20.add(d18, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c20.add(e18, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c20.add(f18, limit2);

        c20.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c20, limit);

        //Casa 21
        limit.gridx = 2;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c21 = new JPanel(new GridBagLayout());
        JPanel a19 = new JPanel();
        a19.setBackground(Color.red);
        JPanel b19 = new JPanel();
        b19.setBackground(Color.black);
        JPanel c19 = new JPanel();
        c19.setBackground(Color.blue);
        JPanel d19 = new JPanel();
        d19.setBackground(Color.gray);
        JPanel e19 = new JPanel();
        e19.setBackground(Color.green);
        JPanel f19 = new JPanel();
        f19.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c21.add(a19, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c21.add(b19, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c21.add(c19, limit2);

        c21.add(a19, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c21.add(b19, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c21.add(c19, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c21.add((new JLabel(new ImageIcon("src/images/negocio.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c21.add(d19, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c21.add(e19, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c21.add(f19, limit2);

        c21.add(d19, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c21.add(e19, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c21.add(f19, limit2);

        c21.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c21, limit);

        //Casa 22
        limit.gridx = 4;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c22 = new JPanel(new GridBagLayout());
        JPanel a20 = new JPanel();
        a20.setBackground(Color.red);
        JPanel b20 = new JPanel();
        b20.setBackground(Color.black);
        JPanel c20 = new JPanel();
        c20.setBackground(Color.blue);
        JPanel d20 = new JPanel();
        d20.setBackground(Color.gray);
        JPanel e20 = new JPanel();
        e20.setBackground(Color.green);
        JPanel f20 = new JPanel();
        f20.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c22.add(a20, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c22.add(b20, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c22.add(c20, limit2);

        c22.add(a20, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c22.add(b20, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c22.add(c20, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c22.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c22.add(d20, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c22.add(e20, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c22.add(f20, limit2);

        c22.add(d20, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c22.add(e20, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c22.add(f20, limit2);

        c22.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c22, limit);

        //Casa 23
        limit.gridx = 6;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c23 = new JPanel(new GridBagLayout());
        JPanel a21 = new JPanel();
        a21.setBackground(Color.red);
        JPanel b21 = new JPanel();
        b21.setBackground(Color.black);
        JPanel c21 = new JPanel();
        c21.setBackground(Color.blue);
        JPanel d21 = new JPanel();
        d21.setBackground(Color.gray);
        JPanel e21 = new JPanel();
        e21.setBackground(Color.green);
        JPanel f21 = new JPanel();
        f21.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c23.add(a21, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c23.add(b21, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c23.add(c21, limit2);

        c23.add(a21, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c23.add(b21, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c23.add(c21, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c23.add((new JLabel(new ImageIcon("src/images/comprador.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c23.add(d21, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c23.add(e21, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c23.add(f21, limit2);

        c23.add(d21, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c23.add(e21, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c23.add(f21, limit2);

        c23.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c23, limit);

        //Casa 24
        limit.gridx = 8;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c24 = new JPanel(new GridBagLayout());
        JPanel a22 = new JPanel();
        a22.setBackground(Color.red);
        JPanel b22 = new JPanel();
        b22.setBackground(Color.black);
        JPanel c22 = new JPanel();
        c22.setBackground(Color.blue);
        JPanel d22 = new JPanel();
        d22.setBackground(Color.gray);
        JPanel e22 = new JPanel();
        e22.setBackground(Color.green);
        JPanel f22 = new JPanel();
        f22.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c24.add(a22, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c24.add(b22, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c24.add(c22, limit2);

        c24.add(a22, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c24.add(b22, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c24.add(c22, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c24.add((new JLabel(new ImageIcon("src/images/4.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c24.add(d22, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c24.add(e22, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c24.add(f22, limit2);

        c24.add(d22, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c24.add(e22, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c24.add(f22, limit2);
        c24.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c24, limit);

        //Casa 25
        limit.gridx = 10;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c25 = new JPanel(new GridBagLayout());
        JPanel a23 = new JPanel();
        a23.setBackground(Color.red);
        JPanel b23 = new JPanel();
        b23.setBackground(Color.black);
        JPanel c23 = new JPanel();
        c23.setBackground(Color.blue);
        JPanel d23 = new JPanel();
        d23.setBackground(Color.gray);
        JPanel e23 = new JPanel();
        e23.setBackground(Color.green);
        JPanel f23 = new JPanel();
        f23.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c25.add(a23, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c25.add(b23, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c25.add(c23, limit2);

        c25.add(a23, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c25.add(b23, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c25.add(c23, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c25.add((new JLabel(new ImageIcon("src/images/compras.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c25.add(d23, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c25.add(e23, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c25.add(f23, limit2);

        c25.add(d23, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c25.add(e23, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c25.add(f23, limit2);

        c25.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c25, limit);

        //Casa 26
        limit.gridx = 12;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c26 = new JPanel(new GridBagLayout());
        JPanel a24 = new JPanel();
        a24.setBackground(Color.red);
        JPanel b24 = new JPanel();
        b24.setBackground(Color.black);
        JPanel c24 = new JPanel();
        c24.setBackground(Color.blue);
        JPanel d24 = new JPanel();
        d24.setBackground(Color.gray);
        JPanel e24 = new JPanel();
        e24.setBackground(Color.green);
        JPanel f24 = new JPanel();
        f24.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c26.add(a24, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c26.add(b24, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c26.add(c24, limit2);

        c26.add(a24, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c26.add(b24, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c26.add(c24, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c26.add((new JLabel(new ImageIcon("src/images/comprador.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c26.add(d24, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c26.add(e24, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c26.add(f24, limit2);

        c26.add(d24, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c26.add(e24, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c26.add(f24, limit2);

        c26.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c26, limit);

        //Casa 27
        limit.gridx = 14;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c27 = new JPanel(new GridBagLayout());
        JPanel a25 = new JPanel();
        a25.setBackground(Color.red);
        JPanel b25 = new JPanel();
        b25.setBackground(Color.black);
        JPanel c25 = new JPanel();
        c25.setBackground(Color.blue);
        JPanel d25 = new JPanel();
        d25.setBackground(Color.gray);
        JPanel e25 = new JPanel();
        e25.setBackground(Color.green);
        JPanel f25 = new JPanel();
        f25.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c27.add(a25, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c27.add(b25, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c27.add(c25, limit2);

        c27.add(a25, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c27.add(b25, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c27.add(c25, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c27.add((new JLabel(new ImageIcon("src/images/bolao.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c27.add(d25, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c27.add(e25, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c27.add(f25, limit2);

        c27.add(d25, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c27.add(e25, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c27.add(f25, limit2);

        c27.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c27, limit);

        //Casa 28
        limit.gridx = 2;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c28 = new JPanel(new GridBagLayout());
        JPanel a26 = new JPanel();
        a26.setBackground(Color.red);
        JPanel b26 = new JPanel();
        b26.setBackground(Color.black);
        JPanel c26 = new JPanel();
        c26.setBackground(Color.blue);
        JPanel d26 = new JPanel();
        d26.setBackground(Color.gray);
        JPanel e26 = new JPanel();
        e26.setBackground(Color.green);
        JPanel f26 = new JPanel();
        f26.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c28.add(a26, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c28.add(b26, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c28.add(c26, limit2);

        c28.add(a26, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c28.add(b26, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c28.add(c26, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c28.add((new JLabel(new ImageIcon("src/images/shop.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c28.add(d26, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c28.add(e26, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c28.add(f26, limit2);

        c28.add(d26, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c28.add(e26, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c28.add(f26, limit2);

        c28.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c28, limit);

        //Casa 39
        limit.gridx = 4;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c29 = new JPanel(new GridBagLayout());
        JPanel a27 = new JPanel();
        a27.setBackground(Color.red);
        JPanel b27 = new JPanel();
        b27.setBackground(Color.black);
        JPanel c27 = new JPanel();
        c27.setBackground(Color.blue);
        JPanel d27 = new JPanel();
        d27.setBackground(Color.gray);
        JPanel e27 = new JPanel();
        e27.setBackground(Color.green);
        JPanel f27 = new JPanel();
        f27.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c29.add(a27, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c29.add(b27, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c29.add(c27, limit2);

        c29.add(a27, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c29.add(b27, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c29.add(c27, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c29.add((new JLabel(new ImageIcon("src/images/comprador.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c29.add(d27, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c29.add(e27, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c29.add(f27, limit2);

        c29.add(d27, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c29.add(e27, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c29.add(f27, limit2);

        c29.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c29, limit);

        //Casa 30
        limit.gridx = 6;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c30 = new JPanel(new GridBagLayout());
        JPanel a28 = new JPanel();
        a28.setBackground(Color.red);
        JPanel b28 = new JPanel();
        b28.setBackground(Color.black);
        JPanel c28 = new JPanel();
        c28.setBackground(Color.blue);
        JPanel d28 = new JPanel();
        d28.setBackground(Color.gray);
        JPanel e28 = new JPanel();
        e28.setBackground(Color.green);
        JPanel f28 = new JPanel();
        f28.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c30.add(a28, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c30.add(b28, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c30.add(c28, limit2);

        c30.add(a28, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c30.add(b28, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c30.add(c28, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c30.add((new JLabel(new ImageIcon("src/images/maratona.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c30.add(d28, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c30.add(e28, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c30.add(f28, limit2);

        c30.add(d28, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c30.add(e28, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c30.add(f28, limit2);

        c30.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c30, limit);

        //Casa 31
        limit.gridx = 8;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c31 = new JPanel(new GridBagLayout());
        JPanel a29 = new JPanel();
        a29.setBackground(Color.red);
        JPanel b29 = new JPanel();
        b29.setBackground(Color.black);
        JPanel c29 = new JPanel();
        c29.setBackground(Color.blue);
        JPanel d29 = new JPanel();
        d29.setBackground(Color.gray);
        JPanel e29 = new JPanel();
        e29.setBackground(Color.green);
        JPanel f29 = new JPanel();
        f29.setBackground(Color.yellow);
        limit2.gridx = 0;
        limit2.gridy = 0;

        c31.add(a29, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c31.add(b29, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c31.add(c29, limit2);

        c31.add(a29, limit2);
        limit2.gridx = 0;
        limit2.gridy = 1;
        c31.add(b29, limit2);
        limit2.gridx = 0;
        limit2.gridy = 2;
        c31.add(c29, limit2);

        limit2.gridx = 1;
        limit2.gridy = 1;
        c31.add((new JLabel(new ImageIcon("src/images/mesada.png"))), limit2);
        limit2.gridx = 3;
        limit2.gridy = 0;

        c31.add(d29, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c31.add(e29, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c31.add(f29, limit2);

        c31.add(d29, limit2);
        limit2.gridx = 3;
        limit2.gridy = 1;
        c31.add(e29, limit2);
        limit2.gridx = 3;
        limit2.gridy = 2;
        c31.add(f29, limit2);

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

        JogaDado joga = new JogaDado();
        lancarDado.addActionListener(joga);
        saldo.setText("Saldo: " + String.valueOf(contro.saldo()));
    }


    /**
     * Método Listener que trata eventos para o botão emprestimo
     */
    private class BotaoEmprestimo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int valor = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite "
                    + "o valor do emprestimo:(Apenas números)")));
            contro.emprestimo(valor);
            saldo.setText("Saldo: " + String.valueOf(contro.saldo()));
            divida.setText("Divida: " + String.valueOf(contro.retDivida()));

        }

    }

    /**
     * Método Listener que trata eventos para o botão jogarDado
     */
    private class JogaDado implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Random nDado = new Random();
            int saiu = nDado.nextInt(6) + 1;
            int casa = Integer.parseInt(contro.anda(saiu));
            System.out.println("Num: " + casa);
            if (casa < 31) {
                numDado.setText("Num Dado: " + saiu);
                contro.fazAcao(String.valueOf(casa));
                saldo.setText("Saldo: " + String.valueOf(contro.saldo()));
                divida.setText("Divida: " + String.valueOf(contro.retDivida()));
                contro.jogadaEspecial(saiu);
                System.out.println("Valor total do sorte grande: " + String.valueOf(contro.retiraDuvida().verTotal()));

            } else {
                contro.fazAcao("31");
                saldo.setText("Saldo: " + String.valueOf(contro.saldo()));
                divida.setText("Divida: " + String.valueOf(contro.retDivida()));

            }

        }

    }

}
