/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Emanuel Santana
 */
public class JanelaBolao extends JFrame {

    private JPanel pq, pp, ps, pt;
    private JButton part, recusar;
    private JLabel per;

    public void janela() {

        pp = new JPanel();
        ps = new JPanel();
        pq = new JPanel(new GridLayout(2, 1));
        pt = new JPanel(new GridLayout(1, 2));
        part = new JButton("Participar");
        recusar = new JButton("Recusar");
        per = new JLabel("Deseja participar do bolão?");

        pt.add(part);
        pt.add(recusar);

        ps.add(pt, BorderLayout.NORTH);
        pp.add(per, BorderLayout.SOUTH);

        pq.add(ps);

        this.add(pp, BorderLayout.CENTER);
        this.add(pq, BorderLayout.SOUTH);

        this.setTitle("Janela do Bolao");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private class BotaoAceita implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * Se aceitar, deve mandar dizendo que aceitou, o número escolhido
             * e esperar.            
             */

        }

    }

    private class BotaoRejeita implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

}
