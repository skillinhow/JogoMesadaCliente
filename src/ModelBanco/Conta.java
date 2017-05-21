/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBanco;

/**
 *
 * @author emanuel
 */
public class Conta {

    private double saldo;
    private String nick;
    private double emp;
    private double devido;

    public Conta(double saldo, String nomeUsuario) {

        this.saldo = saldo;
        this.nick = nomeUsuario;

    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param deposito the saldo to set.
     */
    public void depositar(double deposito) {
        this.saldo = saldo + deposito;
    }

    public double sacar(double valor) {
        return saldo = saldo - valor;
    }

    public void cobraTaxa() {
        this.emp = emp + (emp * 0.10);
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    public double getQuantoDeve() {
        return emp;
    }

    /**
     * Esse método recebe o valor do empréstimo que o cliente fez, e então
     * guarda para que o cliente saiba quanto ele está devendo ao banco.
     *
     * @param valor, esse representa o valor do empréstimo que o cliente fez.
     */
    public void addValorEmp(double valor) {
        this.emp = emp + valor;
    }

    public void addValorDevido(double valor) {
        this.devido = devido + valor;
    }

    public double valorDevido() {
        return devido;
    }

}
