/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Excecoes.SaldoRuimException;
import Model.CobrancaMonstro;
import Model.ComprasEnt;
import Model.Contas;
import Model.Correios;
import Model.DinheiroExtra;
import Model.Doacao;
import Model.FormaBaralho;
import Model.PagueVizinho;
import Model.VaParaFrente;
import ModelBanco.Conta;
import ModelBanco.SorteGrande;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    public Cont() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        corre = forma.fazerBaralhoCorreio();
        co = new Conta(1000, "Emanuel");
        jog2 = new Conta(1000, "Jogador 2");
        sg = new SorteGrande();
        controller = new Cont2();
    }

    public void fazAcao(String numOpcao) throws SaldoRuimException {

        switch (numOpcao) {

            case "1":
            case "11":
            case "19":
            case "22":
                Stack<Correios> cor = this.retiraCarta(1);
                controller.fazAcoesGeral(cor);

                break;

            case "5":
            case "24":
                Stack<Correios> cor2 = this.retiraCarta(2);
                controller.fazAcoesGeral(cor2);
                break;

            case "3":
            case "16":
                Stack<Correios> cor3 = this.retiraCarta(3);
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

                break;
            case "4":
            case "12":
            case "15":
            case "25":
                /**
                 * Compras e entretenimento.
                 */
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
                
                break;
            case "10":
                //Feliz aniversário.
                 JFrame janela = new JFrame("Negócio de Ocasião");
                JPanel b = new JPanel(new GridLayout(2, 1));               
                JPanel pa = new JPanel(new GridLayout(2, 1));               
                JPanel jp = new JPanel(new GridLayout(2, 1));
                JButton bt = new JButton("Jogar Dado");
                JLabel lb = new JLabel("Você acaba de ganhar uma carta por apenas: "); 
                BorderLayout bl = new BorderLayout();
                JPanel pf = new JPanel(bl);
                
                pf.add(bt, BorderLayout.SOUTH);
                
                b.add(pf);
                jp.add(b);
                pa.add(lb);
                pa.add(jp);
                
                janela.add(pa);               
                janela.setSize(400, 400);                
                janela.setVisible(true);
                
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

    public boolean fazJogadaConta(String op, Conta jog, Contas valor) throws SaldoRuimException {

        if (op.equals("1")) {
            if (valor.valorCarta() <= jog.getSaldo()) {
                sg.adicionarTotal(jog.sacar(valor.valorCarta()));
                return true;
            } else {
                throw new SaldoRuimException("Ferrou hein parceria, pede emprestimo");
            }
        } else {
            System.out.println("Rapaz, deixe de ser vagabundo, pague agora");
            return true;
        }

    }

    public boolean fazJogadaDimExtra(Conta jogRecebe, Conta contaJogRetira) {

        DinheiroExtra d = new DinheiroExtra();

        if (d.valorCarta() <= contaJogRetira.getSaldo()) {
            jogRecebe.depositar(contaJogRetira.sacar(d.valorCarta()));
            return true;

        } else {
            throw new SaldoRuimException("Ta sem dinheiro");

        }
    }

    public boolean fazJogadaDoacao(Conta c) {

        Doacao d = new Doacao();
        if (d.valorCarta() <= c.getSaldo()) {
            sg.adicionarTotal(d.valorCarta());
            return true;
        } else {
            throw new SaldoRuimException("peça emprestimo");
        }
    }

    public void emprestimo(double valor, Conta jog) {

        jog.depositar(valor);
        jog.addValorEmp(valor);

    }

    public void fazAcoesGeral(Stack<Correios> cor) {

        Correios aux = cor.pop();

        if (aux instanceof Contas) {
            System.out.println("Contas");
            boolean enq = false;

            Scanner s = new Scanner(System.in);

            Contas c = (Contas) aux;
            do {
                try {
                    System.out.println("deseja pagar agora?\n Se sim, digite 1,"
                            + " se não digite qualquer numero diferente de 1.");
                    enq = fazJogadaConta(s.nextLine(), co, c);
                    System.out.println("saldo " + co.getSaldo());
                } catch (SaldoRuimException e) {
                    System.out.println("digite o valor do empréstimo");
                    double v = s.nextDouble();
                    emprestimo(v, co);

                }
            } while (enq == false);

        } else if (aux instanceof DinheiroExtra) {
            System.out.println("Dinheiro extra");

            boolean fez = false;
            /**
             * Aqui vai receber a conta da qual vai retirar o dinheiro, e a
             * outra é a que vai receber o dinheiro extra, se ele não tiver o
             * dinheiro, ele não faz a operação.
             */
            do {
                try {

                    fez = fazJogadaDimExtra(co, jog2);
                    System.out.println("seu saldo atual é: " + jog2.getSaldo());

                } catch (SaldoRuimException e) {
                    System.out.println("você vai ter que pedir empréstimo, diga quanto deseja:");
                    Scanner s = new Scanner(System.in);
                    double d = s.nextDouble();
                    emprestimo(d, jog2);
                }
            } while (fez == false);

        } else if (aux instanceof Doacao) {
            System.out.println("Doe sangue, não pera, dinheiro");
            boolean opcao = false;
            do {
                try {
                    opcao = fazJogadaDoacao(co);

                } catch (SaldoRuimException e) {

                    System.out.println("você vai ter que pedir empréstimo, diga quanto deseja:");
                    Scanner s = new Scanner(System.in);
                    double d = s.nextDouble();
                    emprestimo(d, jog2);
                }
            } while (opcao == false);

        } else if (aux instanceof PagueVizinho) {
            System.out.println("paga o seu vizinho viado");
            System.out.println(aux.valorCarta());
        } else if (aux instanceof CobrancaMonstro) {
            System.out.println("Cobrança monstro");
            System.out.println(aux.valorCarta());
        } else if (aux instanceof VaParaFrente) {
            System.out.println("Carta era pra andar");
            System.out.println(aux.valorCarta());
        }

    }

}
