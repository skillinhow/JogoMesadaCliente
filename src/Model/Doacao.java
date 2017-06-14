/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe que herda de correios e pode ter um valor para cobrança, deposito ou
 * andar.
 *
 * @author emanuel
 */
public class Doacao extends Correios {

    private final double doacao = 400;

    public Doacao() {

        super();
    }

    @Override
    public double valorCarta() {
        return doacao;
    }

}
