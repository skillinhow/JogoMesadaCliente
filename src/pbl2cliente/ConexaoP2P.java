/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author thelu
 */
public class ConexaoP2P extends Thread {

    private LinkedList lista;
    private DatagramSocket pessoal;
    private DatagramPacket envio;
    private DatagramPacket recebimento;

    public ConexaoP2P(LinkedList jogadores, String meuNick) throws SocketException {
        this.lista = jogadores;
        for (Iterator iterator = jogadores.iterator(); iterator.hasNext();) {
            JogadorP2P next = (JogadorP2P) iterator.next();
            if (meuNick.equals(next.getNick())) {
                pessoal = new DatagramSocket(next.getPorta());
                System.out.println(next.getNick() + next.getPorta());
                break;
            }
        }
    }

    public void enviar(String mensagem, String nickDest, String meuNick) throws IOException {
        byte[] msg = mensagem.getBytes();
        if (nickDest.equals("All")) {
            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                JogadorP2P next = (JogadorP2P) iterator.next();
                if (!nickDest.equals(meuNick)) {
                    envio = new DatagramPacket(msg, msg.length, next.getIp(), next.getPorta());
                    pessoal.send(envio);
                    break;
                }
            }
        } else {
            for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
                JogadorP2P next = (JogadorP2P) iterator.next();
                if (nickDest.equals(next.getNick())) {
                    envio = new DatagramPacket(msg, msg.length, next.getIp(), next.getPorta());
                    pessoal.send(envio);
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] data = new byte[100];
                recebimento = new DatagramPacket(data, data.length);
                pessoal.receive(recebimento);
                System.out.println(new String(recebimento.getData()));
            } catch (IOException e) {
            }
        }

    }

    public DatagramSocket getPessoal() {
        return pessoal;
    }
    
}