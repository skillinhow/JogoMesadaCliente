/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Emanuel Santana
 */
public class Moto extends ComprasEnt {
    private double vCompra;
    private double vVenda;
    
    public Moto(){
    
        super();
        
    }
    
    @Override
    public double valorCompraCarta() {
        return vCompra;
    }

    @Override
    public double valorVendaCarta() {
        return vVenda;
    }
    
    
}
