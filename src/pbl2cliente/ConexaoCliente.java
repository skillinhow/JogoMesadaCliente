/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.ws.Response;

/**
 *
 * @author thelu
 */
public class ConexaoCliente extends Thread {

    private Socket cliente;
    private ObjectInputStream oi;
    private ObjectOutputStream oo;
    private LinkedList<JogadorP2P> players;
    private ConexaoP2P conect;

    public ConexaoCliente() {
        players = new LinkedList();

    }

    public boolean conectar(String ip) {
        try {
            cliente = new Socket(ip, 50000);
            oi = new ObjectInputStream(cliente.getInputStream());
            oo = new ObjectOutputStream(cliente.getOutputStream());

            if (cliente.isConnected()) {
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(ConexaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String[] primeiroContato(String nick) throws IOException, ClassNotFoundException {
        String pacote = "E@" + nick;
        oo.writeObject(pacote);
        oo.flush();

        String resp = (String) oi.readObject();
        String[] x = resp.split("@");
        return x;
    }

    public String[] config(String nick, String qtdPlay, String temp) throws IOException, ClassNotFoundException {
        String pacote = "C@" + qtdPlay + "@" + temp + "@" + nick;
        oo.writeObject(pacote);
        oo.flush();

        String resp = (String) oi.readObject();
        String[] x = resp.split("@");
        return x;
    }

    public String escutar() throws IOException, ClassNotFoundException {
        String pacote = "PP@";
        oo.writeObject(pacote);
        oo.flush();
        String resp = (String) oi.readObject();
        System.out.println(resp);
        String[] x = resp.split("@");
        if ("P2P".equals(x[0])) {
            return resp;
        }
        return null;
    }

    public boolean partidaPronta(String nick) throws IOException, ClassNotFoundException, InterruptedException {
        int cont = 0;
        String x = escutar();
        String[] pct = x.split("@");
        formata(pct);
        String resp = null;
        conect = new ConexaoP2P(players, nick);
        do {
            conect.enviarBroadcast("AR");
            cont++;
            oo.writeObject("R");
            oo.flush();
            resp = (String) oi.readObject();
            if (resp == null) {
                System.out.println("recebeu null aqui");
            }
        } while (!resp.equals("S"));
        return true;
    }

    public void formata(String[] pacote) throws UnknownHostException {
        for (int i = 3; i < pacote.length; i += 3) {
            InetAddress x = InetAddress.getByName(pacote[i + 1]);
            System.out.println(i + 1);
            System.out.println(i + 2);
            JogadorP2P jogador = new JogadorP2P(pacote[i], x, Integer.parseInt(pacote[i + 2]));
            players.add(jogador);
        }
    }

    public Socket getCliente() {
        return cliente;
    }

    public LinkedList<JogadorP2P> getPlayers() {
        return players;
    }

}
