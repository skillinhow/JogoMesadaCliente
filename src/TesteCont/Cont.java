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
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Emanuel Santana
 */
public class Cont {

    private Stack<Correios> corre;
    private Stack<ComprasEnt> compras;
    private FormaBaralho forma;
    Conta co;
    public Cont() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        corre = forma.fazerBaralhoCorreio();
         co = new Conta(1000, "Emanuel");
    }

    public void fazAcao(String numOpcao) throws SaldoRuimException {

        switch (numOpcao) {

            case "1":
            case "11":
            case "19":
            case "22":
                Stack<Correios> cor = this.retiraCarta();
                Correios aux = cor.pop();
                

                if (aux instanceof Contas) {
                    
                    Scanner s = new Scanner(System.in);
                    
                    Contas c = (Contas)aux;                                        
                    fazJogadaConta(s.nextLine(),co, c);
                    System.out.println("saldo " + co.getSaldo() );

                } else if (aux instanceof DinheiroExtra) {
                    DinheiroExtra d = (DinheiroExtra)aux;
                    System.out.println("Ganhou uma bufunfa");
                    System.out.println(aux.valorCarta());
                } else if (aux instanceof Doacao) {
                    System.out.println("Doe sangue, não pera, dinheiro");
                    System.out.println(aux.valorCarta());
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

                break;

        }
    }

    public Stack<Correios> retiraCarta() {
        Random g = new Random();
        int numCartas = 0;
        numCartas = g.nextInt(3) + 1;
        Stack<Correios> aux = new Stack();

        if (corre.empty()) {
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

    public void fazJogadaConta(String op, Conta jog, Contas valor) throws SaldoRuimException {

        SorteGrande sg = new SorteGrande();
       
        if(op.equals("1")){
            if (valor.valorCarta() <= jog.getSaldo()) {
                sg.adicionarTotal(jog.sacar(valor.valorCarta()));
            } else {
                throw new SaldoRuimException("Ferrou hein parceria, pede emprestimo");
            }       
        } 
        else{
            System.out.println("Rapaz, deixe de ser vagabundo, pague agora");
        }

    }
    public void fazJogadaDimDim(Conta jogRecebe, Conta contaJogRetira ){
    
        DinheiroExtra d  = new DinheiroExtra();
        
        if(d.valorCarta() <= contaJogRetira.getSaldo()){        
            jogRecebe.depositar(contaJogRetira.sacar(d.valorCarta()));
            
        }
        else{
            throw new SaldoRuimException("Ta sem dinheiro");
        
        }
    }
    
    public void emprestimo(double valor, Conta jog){
        jog.depositar(valor);
        jog.addValorEmp(valor);
                
    }

}

