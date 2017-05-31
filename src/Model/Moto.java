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

    private double vCompra = 1800;
    private double vVenda = 3700;

    public Moto() {

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
        return "Moto";
    }

}
