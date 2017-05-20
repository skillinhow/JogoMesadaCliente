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
public class Iate extends ComprasEnt {

    private double vCompra = 2300;
    private double vVenda = 3000;

    public Iate() {

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

    @Override
    public String especificaCarta() {
        return "Carta do tipo Iate";
    }
}
