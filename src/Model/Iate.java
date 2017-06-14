package Model;

/**
 * Classe do tipo compras e entretenimento, você pode comprar ela por um valor
 * menor e então vendê-la por um valor maior.
 *
 * @author Emanuel Santana
 */
public class Iate extends ComprasEnt {

    private double vCompra = 2300;
    private double vVenda = 4000;

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
        return "Iate";
    }
}
