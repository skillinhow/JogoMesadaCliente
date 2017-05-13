/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Model.ComprasEnt;
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
    private Stack<Correios> aux;

    public Cont() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        aux = new Stack();
    }

    public void fazAcao(String numOpcao) {

        switch (numOpcao) {

            case "1":
            case "11":
            case "19":
            case "22":
               this.retiraCarta();
                break;

        }
    }

    public Stack<Correios> retiraCarta() {
        Random g = new Random();
        int numCartas = 0;
        numCartas = g.nextInt(3) + 1;
        
        corre = forma.fazerBaralhoCorreio();
        
        for (int i = 0; i < numCartas; i++) {
            aux.push(corre.pop());
        }
        return aux;
    }

}
