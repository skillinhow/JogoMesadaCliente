/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Model.ComprasEnt;
import Model.Contas;
import Model.Correios;
import Model.FormaBaralho;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Emanuel Santana
 */
public class Cont {

    private Stack<Correios> corre;
    private Stack<ComprasEnt> compras;
    private FormaBaralho forma;

    public Cont() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        corre = forma.fazerBaralhoCorreio();
    }

    public void fazAcao(String numOpcao) {

        switch (numOpcao) {

            case "1":
            case "11":
            case "19":
            case "22":
                Stack<Correios> cor = this.retiraCarta();
                Correios aux = cor.pop();
                if(aux instanceof Contas){
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
}
