/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Collections;
import java.util.Stack;

/**
 * Classe que é responsável por gerar os baralhos de cartas correios e
 * entretenimento.
 *
 * @author emanuel
 */
public class FormaBaralho {

    private Stack<ComprasEnt> bEnt;
    private Stack<Correios> bCorreio;

    public FormaBaralho() {

        this.bEnt = new Stack();
        this.bCorreio = new Stack();
    }

    /**
     * Método responsável por criar as cartas do tipo correios, cria 10
     * exemplares de cada carta e então utiliza um método para embaralhá-las.
     *
     * @return o baralho completo de cartas.
     */
    public Stack<Correios> fazerBaralhoCorreio() {

        for (int i = 0; i < 10; i++) {

            Contas c = new Contas();
            Doacao d = new Doacao();
            PagueVizinho pv = new PagueVizinho();
            VaParaFrente va = new VaParaFrente();
            DinheiroExtra de = new DinheiroExtra();
            CobrancaMonstro cm = new CobrancaMonstro();

            bCorreio.add(c);
            bCorreio.add(d);
            bCorreio.add(pv);
            bCorreio.add(va);
            bCorreio.add(de);
            bCorreio.add(cm);
        }

        Collections.shuffle(bCorreio);
        return bCorreio;
    }

    /**
     * Método responsável por criar as cartas do tipo compras e entretenimento,
     * cria 10 exemplares de cada carta e então utiliza um método para
     * embaralhá-las.
     *
     * @return baralho de cartas entretenimento.
     */
    public Stack<ComprasEnt> fazerBaralhobEnt() {

        for (int i = 0; i < 10; i++) {

            Casa ca = new Casa();
            Iate ia = new Iate();
            Moto mo = new Moto();
            Carro cr = new Carro();

            bEnt.add(ca);
            bEnt.add(ia);
            bEnt.add(mo);
            bEnt.add(cr);

        }

        Collections.shuffle(bEnt);
        return bEnt;
    }

}
