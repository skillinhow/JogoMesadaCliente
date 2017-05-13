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
    private String senha;

    public Conta(double saldo, String nomeUsuario, String senha) {

        this.saldo = saldo;
        this.senha = senha;
        this.nick = nomeUsuario;

    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param deposito the saldo to set
     */
    public void depositar(double deposito) {
        this.saldo = saldo + deposito;
    }

    public double sacar(double valor) {
       return saldo = saldo - valor;
    }

    public void cobraTaxa() {
        this.saldo = saldo - (saldo * 0.10);
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

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
