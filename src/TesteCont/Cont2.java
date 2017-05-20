/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Excecoes.SaldoRuimException;
import Model.Carro;
import Model.Casa;
import Model.CobrancaMonstro;
import Model.ComprasEnt;
import Model.Contas;
import Model.Correios;
import Model.DinheiroExtra;
import Model.Doacao;
import Model.FormaBaralho;
import Model.Iate;
import Model.Moto;
import Model.PagueVizinho;
import Model.VaParaFrente;
import ModelBanco.Conta;
import ModelBanco.SorteGrande;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Emanuel Santana
 */
public class Cont2 {

    private Stack<Correios> corre;
    private Stack<ComprasEnt> compras;
    private FormaBaralho forma;
    private double valorDevido;

    private Conta co;
    private Conta jog2;
    private SorteGrande sg;
    private Stack<ComprasEnt> listCartasEnt;

    public Cont2() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        corre = forma.fazerBaralhoCorreio();
        co = new Conta(1000, "Emanuel");
        jog2 = new Conta(1000, "Jogador 2");
        sg = new SorteGrande();
        listCartasEnt = new Stack();

    }

    public Stack<Correios> retiraCartaCorreio(int numCartas) {

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

    public ComprasEnt retiraCartaEnt() {

        if (compras.empty()) {
            compras = forma.fazerBaralhobEnt();
            return compras.pop();

        } else {
            return compras.pop();
        }

    }

    /**
     * Esse método recebe a opção do tipo de carta que o cliente deseja vender.
     * Além de receber a conta do usuário na qual o valor vai ser depositado.
     * Esse laço vê o tamanho da pilha de cartas do tipo Compras e
     * Entretenimento que o cliente possui, e como cada opção representa um tipo
     * de carta esse laço percorre a pilha procurando a primeira carta do tipo
     * desejado. Ao encontrar a carta ela tem seu valor adicionado na conta do
     * cliente, e o laço é interrompido. Após a interrupção do laço as cartas
     * que haviam sido retiradas da pilha, mas que não eram do tipo desejado,
     * são retornadas a pilha original de cartas.
     *
     * @param opCarta, recebe o tipo de carta que o cliente deseja vender.
     * @param jog, conta do usuário na qual o valor da carta será depositado.
     */
    public void fazJogadaEnt(String opCarta, Conta jog) {
        ComprasEnt aux2;  //Variável auxiliar para ajudar no processo de venda.
        Stack<ComprasEnt> compAux = new Stack();  //Pilha auxiliar 

        switch (opCarta) {
            case "1":

                for (int i = 0; i < listCartasEnt.size(); i++) {

                    aux2 = listCartasEnt.pop();
                    if (aux2 instanceof Casa) {
                        jog.depositar(aux2.valorVendaCarta());
                        break;
                    } else {
                        compAux.add(aux2);
                    }
                }
                if (compAux.size() > 0) {
                    for (int i = 0; i < compAux.size(); i++) {
                        listCartasEnt.add(compAux.pop());
                    }
                }
                break;
            case "2":
                for (int i = 0; i < listCartasEnt.size(); i++) {

                    aux2 = listCartasEnt.pop();
                    if (aux2 instanceof Moto) {
                        jog.depositar(aux2.valorVendaCarta());
                        break;
                    } else {
                        compAux.add(aux2);
                    }
                }
                if (compAux.size() > 0) {
                    for (int i = 0; i < compAux.size(); i++) {
                        listCartasEnt.add(compAux.pop());
                    }
                }
                break;
            case "3":
                for (int i = 0; i < listCartasEnt.size(); i++) {

                    aux2 = listCartasEnt.pop();
                    if (aux2 instanceof Iate) {
                        jog.depositar(aux2.valorVendaCarta());
                        break;
                    } else {
                        compAux.add(aux2);
                    }
                }
                if (compAux.size() > 0) {
                    for (int i = 0; i < compAux.size(); i++) {
                        listCartasEnt.add(compAux.pop());
                    }
                }
                break;
            default:
                for (int i = 0; i < listCartasEnt.size(); i++) {

                    aux2 = listCartasEnt.pop();
                    if (aux2 instanceof Carro) {
                        jog.depositar(aux2.valorVendaCarta());
                        break;
                    } else {
                        compAux.add(aux2);
                    }
                }
                if (compAux.size() > 0) {
                    for (int i = 0; i < compAux.size(); i++) {
                        listCartasEnt.add(compAux.pop());
                    }
                }
                break;
        }

    }

    public ComprasEnt retCartaEnt() {
        ComprasEnt aux2 = null;
        Stack<ComprasEnt> compAux = new Stack();
        for (int i = 0; i < listCartasEnt.size(); i++) {

            aux2 = listCartasEnt.pop();
            if (aux2 instanceof Casa) {
                break;
            } else {
                compAux.add(aux2);
            }
        }
        if (compAux.size() > 0) {
            for (int i = 0; i < compAux.size(); i++) {
                listCartasEnt.add(compAux.pop());
            }
        }
        return aux2;
    }

    public boolean fazJogadaConta(String op, Conta jog, Contas carta) throws SaldoRuimException {

        if (op.trim().equals("1")) {
            if (carta.valorCarta() <= jog.getSaldo()) {
                sg.adicionarTotal(jog.sacar(carta.valorCarta()));
                return true;
            } else {
                throw new SaldoRuimException("Saldo insuficiente, pede empréstimo!");
            }
        } else {

            valorDevido = carta.valorCarta();

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
            throw new SaldoRuimException("Saldo insuficiente, faça um empréstimo!");
        }
    }

    public boolean fazJogadaPague(Conta retira, Conta recebe) {
        PagueVizinho valorPag = new PagueVizinho();

        if (valorPag.valorCarta() <= retira.getSaldo()) {
            recebe.depositar(retira.sacar(valorPag.valorCarta()));
            return true;
        } else {
            throw new SaldoRuimException("Saldo insuficiente, faça um empréstimo!");
        }

    }

    public void fazJogadaBolao(int qtdJog, boolean ganhou) {

        if (ganhou == true) {
            jog2.depositar((qtdJog * 100) + 1000);
        } else {
            jog2.sacar((qtdJog * 100) + 1000);
        }

    }

    public boolean fazCobrancaMonstro(String op, Conta retira) {

        CobrancaMonstro cb = new CobrancaMonstro();
        if (op.equals("1")) {
            if (cb.valorCarta() <= retira.getSaldo()) {
                retira.sacar(cb.valorCarta());
                return true;
            } else {
                throw new SaldoRuimException("Saldo insuficiente, faça um empréstimo!");
            }

        } else {
            valorDevido = cb.valorCarta();
            return true;
        }

    }

    public double saldo() {
        return jog2.getSaldo();
    }

    public boolean diaMesada(Conta retira) {

        retira.depositar(3500);
        retira.cobraTaxa();
        if (valorDevido <= retira.getSaldo()) {
            retira.sacar(valorDevido);
            return true;
        } else {
            throw new SaldoRuimException("Saldo insuficiente, você tem a "
                    + "obrigação de pagar,! Então faça um empréstimo!");
        }

    }

    public void emprestimo(double valor) {

        jog2.depositar(valor);
        jog2.addValorEmp(valor);

    }

    public double retDivida() {
        return jog2.getQuantoDeve();
    }

    public void fazJogadaPremio(Conta con) {
        con.depositar(5000);
        JOptionPane.showMessageDialog(null, "Parabéns, você ganhou 5000");

    }

    public void jogadaBolao(Stack<Conta> jgd, Conta vencedor) {

        for (int i = 0; i < jgd.size(); i++) {
            //Falta muito, pensei que era mais fácil.

            vencedor.depositar(jgd.pop().sacar(100));
        }
    }

    public void fazJogadaDiversao(Conta jog) {

        if (jog.getSaldo() <= 100) {
            sg.adicionarTotal(jog.sacar(100));
        } else {
            throw new SaldoRuimException("Saldo insuficiente, peça um empréstimo");
        }
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
                    emprestimo(v);

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
                    emprestimo(d);
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
                    emprestimo(d);
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
