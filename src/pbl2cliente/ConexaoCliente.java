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

    public static void main(String[] args) {
        Socket cliente;

        try {
            cliente = new Socket("127.0.0.1", 50000);
            ObjectInputStream oi = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream oo = new ObjectOutputStream(cliente.getOutputStream());

            String pacote = "E@maria";

            oo.writeObject(pacote);
            oo.flush();

            String resp = (String) oi.readObject();

            if (resp.equals("C")) {
                oo.writeObject("C@2@1@joao");
                oo.flush();
            }

            resp = (String) oi.readObject();
            if (resp.equals("H")) {
                while (!resp.equals("S")) {
                    int x = 0;
                    System.out.println("aguarde " + x);
                    x++;
                }
            }

            System.out.println(resp);

        } catch (IOException ex) {
            Logger.getLogger(ConexaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
