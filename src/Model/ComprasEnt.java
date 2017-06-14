/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Várias classes pode extender dessa classe criando novos tipos de cartas do
 * tipo compras e entretenimento.
 *
 * @author emanuel
 */
public abstract class ComprasEnt {

    /**
     * Método que vai mostrar para o cliente o valor de compra da carta.
     *
     * @return valor de compra da carta.
     */
    public abstract double valorCompraCarta();

    /**
     * Método que retorna para o cliente o valor de venda desta carta.
     *
     * @return valor de venda da carta.
     */
    public abstract double valorVendaCarta();

    /**
     * método responsável por retornar a especificação da carta.
     *
     * @return a especificação da carta.
     */
    public abstract String especificaCarta();
}
