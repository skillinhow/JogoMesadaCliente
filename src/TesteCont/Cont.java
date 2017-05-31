/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Excecoes.SaldoRuimException;
import Model.ComprasEnt;
import Model.Correios;
import Model.FormaBaralho;
import ModelBanco.Conta;
import ModelBanco.SorteGrande;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Emanuel Santana
 */
public class Cont {

    private Stack<Correios> corre;
    private SorteGrande sg;
    private Stack<ComprasEnt> compras;
    private FormaBaralho forma;
    private Conta co;
    private Conta jog2;
    private Cont2 controller;
    private JButton dado;
    private JPanel p1, p2, p3;
    private JLabel l1, l2;
    private int cont;
    private JFrame frame;

    public Cont() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        co = new Conta(1000, "Emanuel");
        jog2 = new Conta(1000, "Jogador 2");
        sg = new SorteGrande();
        controller = new Cont2();
        frame = new JFrame();
    }

    public void fazAcao(String numOpcao) {

        switch (numOpcao) {

            case "1":
            case "11":
            case "19":
            case "22":
                Stack<Correios> cor = controller.retiraCartaCorreio(1);
                controller.fazAcoesGeral(cor);
                break;

            case "5":
            case "24":
                Stack<Correios> cor2 = controller.retiraCartaCorreio(2);
                controller.fazAcoesGeral(cor2);
                break;

            case "3":
            case "16":
                Stack<Correios> cor3 = controller.retiraCartaCorreio(3);
                controller.fazAcoesGeral(cor3);
                break;
            case "2":
                controller.fazJogadaPremio(jog2);

                break;

            case "6":
            case "13":
            case "20":
            case "27":

                /**
                 * Recebe a quantidade de jogadores, multiplica por 100, soma
                 * com 1000 do banco, e espera os jogadores jogarem o dado, o
                 * primeiro que tirar 3 recebe o valor total do bolão. esboço
                 * 1:.
                 *
                 * this.jogadaBolao(qtdJogadores);
                 *
                 * public void jogadaBolao(int qtdJogadores, Jogador vencedor){
                 * int totalBolao = qtdJogadores*100;
                 * vencedor.depositar(totalBolao); } o parametro recebido é a
                 * quantidade de jogadores que vão participar.
                 *
                 */
                int qtdJog = 0;

                controller.fazJogadaBolao(qtdJog, true);

                break;
            case "7":
            case "14":
            case "18":
            case "28":
                /**
                 * Em todos esses casos deve ser depositado um valor específico
                 * no sorte grande, caso não tenha dinheiro é necessário pedir
                 * empréstimo, e ficou padronizado para que seja todos o mesmo
                 * valor. Esboço:.
                 *
                 * public void fazJogadaDiversao(Jogador jog){
                 *
                 * if(jog.getSaldo() menor ou igual 100 ){
                 *
                 * sg = jog.sacar(100); } else throw new
                 * SaldoRuimException("Saldo insuficiente, peça um empréstimo");
                 * } .
                 *
                 */
                try {
                    controller.fazJogadaDiversao();
                } catch (SaldoRuimException e) {
                    JOptionPane.showInputDialog("Peça um empréstimo! Digite o valor abaixo");
                }
                break;
            case "4":
            case "12":
            case "15":
            case "25":
                /**
                 * Compras e entretenimento. Nesse método o cliente tira uma
                 * carta e escolhe se quer comprar ou não. Se ele quiser, a
                 * carta é adicionada na lista de cartas dele.
                 */
                ComprasEnt ce;
                ce = controller.retiraCartaEnt();

                int desejo = JOptionPane.showConfirmDialog(null, "Deseja comprar "
                        + ce.especificaCarta() + " por: " + String.valueOf(ce.valorCompraCarta()) + "?"
                        + "\nValor da Venda: " + String.valueOf(ce.valorVendaCarta()));

                if (desejo == 0) {
                    System.out.println("Chegou na hora certa!");
                    compras.add(ce);
                }
                break;
            case "9":
            case "17":
            case "23":
            case "26":
            case "29":
                /**
                 * Achou comprador.
                 */
                break;

            case "8":
                //Concurso de Banda de Arrocha.
                /**
                 * Esse numero que está sendo passado é numero do dado, além
                 * disso precisamos criar uma variável que indique se é a vez do
                 * jogador.
                 */
                //int numDado = 0;
                //controller.fazJogadaArrocha(numDado);
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

                frame.add(p3, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(2);
                frame.setSize(450, 300);
                frame.setTitle("Concurso de Arrocha");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                break;
            case "10":
                //Feliz aniversário.                

                break;
            case "21":
                //Negócio de ocasião.

                break;
            case "30":
                //Maratona.
                break;
            case "31":
                /**
                 * Dia de Mesada, retira um valor de 3500.
                 */
                break;

        }
    }

    public Stack<Correios> retiraCarta(int numCartas) {

        Stack<Correios> aux = new Stack();

        if (corre.empty() || corre.size() < numCartas) {
            System.out.println("Tava vazio");
            corre = forma.fazerBaralhoCorreio();

            for (int i = 0; i < numCartas; i++) {
                aux.push(corre.pop());
            }
        } else {

            for (int i = 0; i < numCartas; i++) {
                aux.push(corre.pop());
            }

        }
        return aux;
    }

    public ComprasEnt retCartaEnt() {

        if (compras.empty()) {

            compras = forma.fazerBaralhobEnt();
            return compras.pop();

        } else {
            return compras.pop();

        }

    }

    /**
     *
     * public boolean fazJogadaConta(String op, Conta jog, Contas valor) throws
     * SaldoRuimException {
     *
     * if (op.equals("1")) { if (valor.valorCarta() <= jog.getSaldo()) {
     * sg.adicionarTotal(jog.sacar(valor.valorCarta())); return true; } else {
     * throw new SaldoRuimException("Ferrou hein parceria, pede emprestimo"); }
     * } else { System.out.println("Rapaz, deixe de ser vagabundo, pague
     * agora"); return true; }
     *
     * }
     *
     * public boolean fazJogadaDimExtra(Conta jogRecebe, Conta contaJogRetira) {
     *
     * DinheiroExtra d = new DinheiroExtra();
     *
     * if (d.valorCarta() <= contaJogRetira.getSaldo()) {
     * jogRecebe.depositar(contaJogRetira.sacar(d.valorCarta())); return true;
     *
     * } else { throw new SaldoRuimException("Ta sem dinheiro");
     *
     * }
     * }
     *
     * public boolean fazJogadaDoacao(Conta c) {
     *
     * Doacao d = new Doacao(); if (d.valorCarta() <= c.getSaldo()) {
     * sg.adicionarTotal(d.valorCarta()); return true; } else { throw new
     * SaldoRuimException("peça emprestimo"); } }
     *
     * public void emprestimo(double valor, Conta jog) {
     *
     * jog.depositar(valor); jog.addValorEmp(valor);
     *
     * }
     */
    private class BotaoJoga implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            /**
             * Chamar o método de concurso arrocha, e passar a jogada pra todos,
             * após isso, ele tem também que chamar o próximo jogador caso o que
             * jogou não tenha vencido o concurso.
             */
            cont++;
            if (cont == 1) {
                Random r = new Random();
                int dado = r.nextInt(6) + 1;
                boolean ganhou = controller.fazJogadaArrocha(dado);
                l2.setText("Número sorteado: " + dado);

                if (ganhou == true) {
                    JOptionPane.showMessageDialog(null, "Parabéns você ganhou o concurso \n "
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
