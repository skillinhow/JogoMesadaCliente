/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Classe do tipo compras e entretenimento, você pode comprar ela por um valor
 * menor e então vendê-la por um valor maior.
 *
 * @author Emanuel Santana
 */
public class Carro extends ComprasEnt {

    private double vCompra = 2500;
    private double vVenda = 5700;

    public Carro() {

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
        return "Carro";
    }

}
