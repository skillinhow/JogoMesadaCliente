/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2cliente;

import View.TelaPrincipal;
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
    private String resposta;
    public static boolean allReady = false;

    public ConexaoP2P(LinkedList jogadores, String meuNick) throws SocketException {
        this.lista = jogadores;
        this.resposta = null;
        for (Iterator iterator = jogadores.iterator(); iterator.hasNext();) {
            JogadorP2P next = (JogadorP2P) iterator.next();
            if (meuNick.equals(next.getNick())) {
                pessoal = new DatagramSocket(next.getPorta());
                System.out.println("Iniciando ClienteDatagram na porta - " + next.getPorta());
                System.out.println("Estado da Conexão - " + pessoal.isBound());
                this.start();

                System.out.println(next.getNick() + " " + next.getPorta());
                break;
            }
        }
    }

    public void enviarBroadcast(String mensagem) throws IOException {
        byte[] msg = mensagem.getBytes();
        Iterator itera = lista.iterator();
        
        while(itera.hasNext()){
            JogadorP2P next = (JogadorP2P) itera.next();
            if (pessoal.getLocalPort() != next.getPorta()) {
                envio = new DatagramPacket(msg, msg.length, next.getIp(), next.getPorta());
                pessoal.send(envio);
            }
        }
        /*
        
        for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
            JogadorP2P next = (JogadorP2P) iterator.next();
            if (pessoal.getLocalPort() != next.getPorta()) {
                envio = new DatagramPacket(msg, msg.length, next.getIp(), next.getPorta());
                pessoal.send(envio);
            }
        }*/
    }

    public void enviarDireto(String mensagem, String nickDest) throws IOException {
        byte[] msg = mensagem.getBytes();
        for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
            JogadorP2P next = (JogadorP2P) iterator.next();
            if ((nickDest.equals(next.getNick())) || (next.getPorta() == Integer.parseInt(nickDest))) {
                envio = new DatagramPacket(msg, msg.length, next.getIp(), next.getPorta());
                pessoal.send(envio);
                break;
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
                resposta = new String(recebimento.getData());
                System.out.println("Recebeu " + new String(recebimento.getData()) + " de " + recebimento.getPort());

                System.out.println(resposta);

                if (resposta.trim().equals("AR")) {
                    System.out.println("Resposta certaaaa");
                    enviarBroadcast("Recebido");
                    /**
                     * É necesário que você limpe toda vez antes de executar.
                     * agora dá pra fazer.
                     */

                } else {
                    System.out.println("quaquer coisa 1234");
                    System.out.println("Essa poha vai chegar aqui!");
                    System.out.println("Fudeu, saiu: " + resposta);
                    System.out.println("Fudeu mais uma: " + new String(recebimento.getData()));
                }

            } catch (IOException e) {
            }
        }

    }

    public DatagramSocket getPessoal() {
        return pessoal;
    }

}
