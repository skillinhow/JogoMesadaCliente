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
import ModelBanco.Conta;
import ModelBanco.SorteGrande;
import java.util.Stack;

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

    public Cont2() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        corre = forma.fazerBaralhoCorreio();
        co = new Conta(1000, "Emanuel");
        jog2 = new Conta(1000, "Jogador 2");
        sg = new SorteGrande();

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

    public boolean fazJogadaConta(String op, Stack<Contas> listaAnt, Conta jog, Contas carta) throws SaldoRuimException {

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
    public boolean diaMesada(Conta retira){
        
        if(valorDevido <= retira.getSaldo()){            
            retira.sacar(valorDevido);  
            return true;
        }
        else{
        throw new SaldoRuimException("Saldo insuficiente, você tem a obrigação de pagar"
                + " então faça um empréstimo!");        
        }    
            
    }
    

    public void emprestimo(double valor, Conta jog) {
        jog.depositar(valor);
        jog.addValorEmp(valor);

    }

}
