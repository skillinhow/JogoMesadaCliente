/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe responsável por estabelecer e tratar as comunicações Cliente-Servidor e Cliente-Cliente
 *
 * @author Lucas Cardoso e Emanuel Santana
 */
public class ControllerConexao extends Thread {

    private Socket socket;
    private String ip;
    private ObjectOutputStream oo;
    private ObjectInputStream oi;

    private DatagramSocket dataSkt;
    private DatagramPacket dataS, dataR;
    private LinkedList<Jogadores> players;
    public static String mens = "a";
    public static double valor = 0;
    public static int numJog = 0;
    public static int contadorPosicao = 0;

    /**
     * Construtor padrão da classe
     */
    public ControllerConexao() {
        players = null;
    }

    /**
     * Método para estabelecer uma conexão via Socket com o Servidor.
     * Estabelece  a conexão com o servidor e inicia o DatagramSocket
     * 
     * @param ip Recebe o IP do Servidor
     * @param porta Recebe a porta do Servidor
     * @return Retorna um objeto do tipo Socket para manipulação da conexão
     * @throws IOException Lança a exceção caso encontre algum erro em abrir o Socket
     */
    public Socket conectar(String ip, int porta) throws IOException {
        socket = new Socket(ip, porta);
        System.out.println("Porta TCP - " + socket.getLocalPort());
        dataSkt = new DatagramSocket((socket.getLocalPort() + 15));
        System.out.println("Porta UDP - " + (socket.getLocalPort() + 15));

        oo = new ObjectOutputStream(socket.getOutputStream());
        oi = new ObjectInputStream(socket.getInputStream());
        return socket;
    }

    /**
     * Método responsável por realizar o primeiro contato com o Servidor.
     * Realiza o contato com o servidor e trata algumas respostas.
     * @param nick Recebe o nick do jogador
     * @return Retorna um valor inteiro significando uma ação do controller
     * @throws IOException Lança a exceção caso encontre erro em enviar as mensagens.
     * @throws ClassNotFoundException  Lança a exceção caso haja erro de casting
     */
    public int contato(String nick) throws IOException, ClassNotFoundException {

        String pacote = "E@" + nick;

        oo.writeObject(pacote);
        oo.flush();

        String resp = (String) oi.readObject();
        System.out.println("Recebi - " + resp + " no contato");

        if (resp.equals("C")) {
            System.out.println("Config");
            return 1;
        } else if (resp.equals("H")) {
            System.out.println("Espera");
            return 2;
        }

        return 0;
    }

    /**Método que trata da configuração de uma sala.
     * 
     * @param numPlay Recebe o número de jogadores daquela partida.
     * @param numTemp Recebe o tempo de duração da partida em meses
     * @param nick Recebe o nick do jogador.
     * @return Retorna um valor inteiro significando uma ação para o controller
     * @throws IOException Lança a exceção caso não consiga enviar as mensagens
     * @throws ClassNotFoundException  Lança a exceção caso haja erro de casting
     */
    public int config(String numPlay, String numTemp, String nick) throws IOException, ClassNotFoundException {

        String pacote = "C@" + numPlay + "@" + numTemp + "@" + nick;

        oo.writeObject(pacote);
        oo.flush();

        String resp = (String) oi.readObject();
        System.out.println("Recebi - " + resp + " na config");

        if (resp.equals("H")) {
            System.out.println("Aguarde");
            return 2;
        }
        return 0;
    }

    /**Método que verifica se a sala está pronta para iniciar o jogo.
     * 
     * @return Retorna um inteiro significando uma ação para o controller
     * @throws IOException Lança a exceção caso não consiga envia as mensagens
     * @throws ClassNotFoundException Lança a exceção caso haja erro de casting
     */
    public int espera() throws IOException, ClassNotFoundException{

        String pacote = "R";

        oo.writeObject(pacote);
        oo.flush();

        String resp = (String) oi.readObject();
        String[] aux = resp.split("@");
        System.out.println("Recebi - " + resp + " na espera");

        if (aux[0].equals("Y")) {
            geraLista(aux);

            start();
            System.out.println("Pode começar sim!");
            do {
                mandaAll("T@Z");
            } while (!mens.equals("O"));

            return 4;
        } else if (aux[0].equals("N")) {
            System.out.println("Ainda não pode começar!");
            return 5;
        } else {
        }
        return 0;
    }

    /**Método que gera uma lista de jogadores com base nas informações recebidas do servidor.
     * Utiliza uma String recebida do servidor para criar uma listsa com os jogadores e seus respectivos IP e porta.
     * 
     * @param aux Recebe um vetor que contem as informações passadas pelo servidor
     */
    public void geraLista(String[] aux) {
        players = new LinkedList<>();
        for (int i = 3; i < aux.length; i += 3) {
            int novaPorta = Integer.parseInt(aux[i + 2]) + 15;
            Jogadores x = new Jogadores(aux[i], aux[(i + 1)], "" + novaPorta);
            players.add(x);
        }
        for (Iterator<Jogadores> iterator = players.iterator(); iterator.hasNext();) {
            Jogadores next = iterator.next();
            System.out.println("Nick - " + next.getNick());
            System.out.println("IP - " + next.getIp());
            System.out.println("Porta - " + next.getPorta());
        }
    }

    /**Método que escuta as mensagens vindas de outros jogadores.
     * Realiza também um primeiro tratamento das infomações passadas pelos outros jogadores
     * 
     * @throws IOException Lança a exceção caso haja erro no recebimento das informações
     */
    public void escuta() throws IOException {

        while (true) {
            byte[] dados = new byte[500];
            dataR = new DatagramPacket(dados, dados.length);
            dataSkt.receive(dataR);

            String recb = new String(dataR.getData());
            String[] aux = recb.trim().split("@");

            if (aux[0].equals("T")) {
                mandaAll("O@Z");
                mens = "O";
            } else if (aux[0].equals("B")) {
                System.out.println("aqui");
                int op = JOptionPane.showConfirmDialog(null, "Deseja participar do Bolão");
                if (op == 0) {
                    String x = JOptionPane.showInputDialog("Digite um número de 1 a 6");

                    mandaAll("Q@" + x);
                }

                mens = "B";
                System.out.println("mens " + mens);
            } else if (aux[0].equals("Q")) {
                mens = "Q";

            } else if (aux[0].equals("SA")) {
                System.out.println("Valor do saque " + aux[1]);
                mens = "SA";
                valor = Double.parseDouble(aux[1]);
            } else if (aux[0].equals("JA")) {
                mens = "JA";
            } else if (aux[0].equals("DE")) {
                System.out.println("Valor do deposito " + aux[1]);
                mens = "DE";
                valor = Integer.parseInt(aux[1]);
            }
        }

    }

    /**Método que retorna a lista de jogadores naquela partida
     * 
     * @return Retorna a lista de jogadores da partida
     */
    public LinkedList<Jogadores> listaJogadores() {
        return players;
    }

    /**
     * Método que retorna as informações da conexão Datagram
     * @return Retorna o objeto DatagramSocket
     */
    public DatagramSocket minhasInfomacoes() {
        return dataSkt;
    }
    
    /**
     * Método que envia uma mensagem para todos os jogadores da partida.
     * Funciona como um emissor de mensagem em Broadcast.
     * @param mensagem Recebe a mensagem a ser enviada
     * @throws IOException Lança a exceção caso não consiga enviar a mensagem
     */
    public void mandaAll(String mensagem) throws IOException {
        byte[] msg = mensagem.getBytes();
        for (Iterator iterator = players.iterator(); iterator.hasNext();) {
            Jogadores next = (Jogadores) iterator.next();
            InetAddress x = InetAddress.getByName(next.getIp());
            if (dataSkt.getLocalPort() != Integer.parseInt(next.getPorta())) {
                dataS = new DatagramPacket(msg, msg.length, x, Integer.parseInt(next.getPorta()));
                dataSkt.send(dataS);
            }
        }

    }

    /**Método que envia uma mensgem a um jogador especifico.
     * 
     * @param mensagem Recebe a mensagem a ser enviada
     * @param nick Recebe o nick do jogador que irá receber a mensagem
     * @throws IOException Lança a exceção caso não consiga enviar a mensagem
     */
    public void manda(String mensagem, String nick) throws IOException {
        byte[] msg = mensagem.getBytes();
        Jogadores aux5;
        Iterator iterator = players.iterator();

        do {

            aux5 = (Jogadores) iterator.next();
            System.out.println("Jogador da vez no iterador: " + aux5.getNick());
            if (aux5.getNick().equals(nick) && (dataSkt.getLocalPort() != Integer.parseInt(aux5.getPorta()))) {
                dataS = new DatagramPacket(msg, msg.length, InetAddress.getByName(aux5.getIp()), Integer.parseInt(aux5.getPorta()));
                dataSkt.send(dataS);
                if (contadorPosicao >= players.size()) {
                    contadorPosicao = 0;
                }
            }
            contadorPosicao++;
        } while (!aux5.getNick().equals(nick));

    }

    /**
     * Método que inicia a Trhead que escuta as mensagens de outros jogadores.
     */
    @Override
    public void run() {

        try {
            escuta();
        } catch (IOException ex) {
            Logger.getLogger(ControllerConexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
