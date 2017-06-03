/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Emanuel Santana
 */
public class AchouComprador extends JFrame {

    private JPanel p1, p2, p3, p4, geral;
    private JButton b1, b2, b3, b4;
    private JLabel l1;

    public void criouJanela() {

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        geral = new JPanel(new GridLayout(2, 2));
        l1 = new JLabel("Escolha qual item deseja vender");
        b1 = new JButton("Vender Moto");
        b2 = new JButton("Vender Carro");
        b3 = new JButton("Vender Iate");
        b4 = new JButton("Vender Casa");
        
        p1.add(b1, BorderLayout.CENTER);
        p2.add(b2, BorderLayout.CENTER);
        p3.add(b3, BorderLayout.CENTER);
        p4.add(b4, BorderLayout.CENTER);
        

        geral.add(p1);
        geral.add(p2);
        geral.add(p3);
        geral.add(p4);

        this.add(l1, BorderLayout.NORTH);
        this.add(geral, BorderLayout.CENTER);
        this.setDefaultCloseOperation(2);
        this.setLocationRelativeTo(null);
        this.setSize(400, 300);
        this.setVisible(true);

    }

}
