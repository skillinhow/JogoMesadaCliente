/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import TesteCont.Cont2;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Emanuel Santana
 */
public class JanelaArrocha extends JFrame {

    private JButton dado;
    private JPanel p1, p2, p3;
    private JLabel l1, l2;
    private int cont;

    public void fazTela() {
        dado = new JButton("Jogar Dado");
        l1 = new JLabel("Você está participando do concurso de banda de arrocha.");
        dado.setSize(15, 30);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel(new GridLayout(2, 1));
        l2 = new JLabel();

        p1.add(l2, BorderLayout.NORTH);
        p1.add(dado);
        p2.add(l1);
        p3.add(p2);
        p3.add(p1, BorderLayout.SOUTH);

        BotaoJoga bj = new BotaoJoga();
        dado.addActionListener(bj);

        this.add(p3, BorderLayout.CENTER);
        this.setDefaultCloseOperation(2);
        this.setSize(450, 300);
        this.setTitle("Concurso de Arrocha");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private class BotaoJoga implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * Chamar o método de concurso arrocha, e passar a jogada pra todos
             * após isso, ele tem também que chamar o próximo.
             */
            cont++;
            if (cont == 1) {
                int dado = new Random(6).nextInt() + 1;
                Cont2 c = new Cont2();
                boolean ganhou = c.fazJogadaArrocha(dado);
                l2.setText("Número sorteado: " + dado);
                if (ganhou == true) {
                    JOptionPane.showMessageDialog(null, "Parabéns você ganhou o concurso /n "
                            + "e recebeu 1000");
                } else {
                    JOptionPane.showMessageDialog(null, "Você não ganhou o prêmio :-(");
                    //Chamar o método de proximo jogador, e zera o dado
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você ja jogou o dado!");
            }
        }

    }

}
