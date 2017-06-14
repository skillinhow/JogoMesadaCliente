package Model;

/**
 * Classe do tipo compras e entretenimento, você pode comprar ela por um valor
 * menor e então vendê-la por um valor maior.
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
