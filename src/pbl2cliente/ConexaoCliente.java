/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thelu
 */
public class ConexaoCliente {

    private Socket cliente;
    private ObjectInputStream oi;
    private ObjectOutputStream oo;

    public ConexaoCliente() {

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
        String[] x;
        String resp;
        do {
            resp = (String) oi.readObject();
            x = resp.split("@");
        } while (!"S".equals(x[0]));
        
        return resp;

    }

    public Socket getCliente() {
        return cliente;
    }
    

    public static void main(String[] args) {

    }
}
