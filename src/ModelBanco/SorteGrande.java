/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelBanco;

/**
 * Classe que recebe alguns valores no jogo.
 *
 * @author Emanuel Santana
 */
public class SorteGrande {

    private double total = 0;

    public SorteGrande() {
        this.total = total;
    }

    /**
     * Método que verifica o saldo do sorte grande.
     *
     * @return o valor total do sorte grande.
     */
    public double verTotal() {
        return total;
    }

    /**
     * Método que adiciona ao valor total do sorte grande.
     *
     * @param add valor a ser depositado no sorte grande.
     */
    public void adicionarTotal(double add) {
        this.total = total + add;
    }

    /**
     * Faz um saque no valor total do sorte grande.
     *
     * @param add valor a ser retirado.
     */
    public void retirarTotal(double add) {
        this.total = total - add;
    }

}
