/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author emanuel
 */
public class DinheiroExtra extends Correios {

    private double valor = 5000;

    public DinheiroExtra() {
        
        super();
    }

    @Override
    public double valorCarta() {
        
        return valor;
        
    }

}
