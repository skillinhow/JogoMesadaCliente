/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2cliente;

/**Classe que abriga as informações de cada jogador na partida.
 * Formato da célula utilizada para cirar a lista de jogadores.
 *
 * @author Lucas Cardoso e Emanuel Santana
 */
public class Jogadores {

    private String nick;
    private String ip;
    private String porta;
    private int sala;

    /**
     * Construtor da classe
     * @param nick Recebe o nick do jogador
     * @param ip Recebe o IP do jogador
     * @param porta Recebe a porta do jogador
     */
    public Jogadores(String nick, String ip, String porta) {
        this.nick = nick;
        this.ip = ip;
        this.porta = porta;
    }

    public String getNick() {
        return nick;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getIp() {
        return ip;
    }

    public String getPorta() {
        return porta;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

}
