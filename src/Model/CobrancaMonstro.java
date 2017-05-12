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
public class CobrancaMonstro extends Correios{

    private double valor = 400;
    
    public CobrancaMonstro(){
    
        super();
    
    }

    @Override
    public double valorCarta() {
       return valor;
    }
    
}
