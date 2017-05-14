/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2cliente;

import java.net.InetAddress;

/**
 *
 * @author thelu
 */
public class JogadorP2P {
    
    private String nick;
    private InetAddress ip;
    private int porta;

    public JogadorP2P(String nick, InetAddress ip, int porta) {
        this.nick = nick;
        this.ip = ip;
        this.porta = porta;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    
    
}
