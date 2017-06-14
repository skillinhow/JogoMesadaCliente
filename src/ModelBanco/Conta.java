/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBanco;

/**
 * Classe conta que recebe os dados do cliente e cria uma conta
 *
 * @author emanuel
 */
public class Conta {

    private double saldo;
    private String nick;
    private double emp;
    private double devido;
    private double jurosEmp;

    public Conta(double saldo, String nomeUsuario) {

        this.saldo = saldo;
        this.nick = nomeUsuario;

    }

    /**
     * @return o saldo do cliente.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param deposito na conta do cliente.
     */
    public void depositar(double deposito) {
        this.saldo = saldo + deposito;
    }

    /**
     * Realiza um saque na conta do jogador.
     *
     * @param valor valor a ser retirado.
     * @return o valor atual da conta.
     */
    public double sacar(double valor) {
        return saldo = saldo - valor;
    }

    /**
     * Método que retorna os juros do empréstimo do jogador.
     *
     * @return valor dos júros.
     */
    public double retJuros() {
        return jurosEmp;
    }

    /**
     * Cobra uma taxa de 10% sobre o valor total devido pelo jogador, e então
     * adiciona esse valor ao valor total de dívida.
     */
    public void cobraTaxa() {
        this.jurosEmp = jurosEmp + (emp * 0.10);
    }

    /**
     * @return the nick do jogador.
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
     * Método que retorna o valor devido de empréstimo do cliente.
     *
     * @return o valor devido.
     */
    public double getQuantoDeve() {
        //Se trata do valor devido de emprestimo.
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

    /**
     * Método que recebe um valor e netão adiciona ao valor total de cartas
     * correios do jogador.
     *
     * @param valor valor a ser adicionado no saldo devido pelo cliente.
     */
    public void addValorDevido(double valor) {
        this.devido = devido + valor;
    }

    /**
     * @return o valor devido de cartas correios.
     */
    public double valorDevido() {
        return devido;
    }

    /**
     * Método que recebe um valor e então paga o empréstimo.
     *
     * @param valor valor a ser decremetado do empréstimo.
     */
    public void pagarEmprestimo(double valor) {

        this.emp = emp - valor;
    }

    /**
     * Paga o valor devido pelas cartas correios.
     *
     * @param valor valor a ser decontado da dívida.
     */
    public void pagarValor(double valor) {
        this.devido = devido - valor;
    }

}
