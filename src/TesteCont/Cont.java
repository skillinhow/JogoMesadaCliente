/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Excecoes.SaldoRuimException;
import Model.Carro;
import Model.Casa;
import Model.ComprasEnt;
import Model.Correios;
import Model.Iate;
import Model.Moto;
import ModelBanco.SorteGrande;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pbl2cliente.ControllerConexao;
import pbl2cliente.Jogadores;

/**
 *
 * @author Emanuel Santana
 */
public class Cont {

    private final Stack<ComprasEnt> compras;
    private final Cont2 controller;
    private int cont;
    private ControllerConexao control;

    public Cont(ControllerConexao x) {
        compras = new Stack();
        controller = new Cont2();
        this.control = x;
    }

    public SorteGrande retiraDuvida() {
        return controller.tiraDuvida();

    }

    public double saldo() {
        return controller.saldo();
    }

    public String anda(int saiu) {
        return controller.anda(saiu);
    }

    public double retDivida() {
        return controller.retDivida();
    }

    public void emprestimo(double valor) {
        controller.emprestimo(valor);
    }

    public void jogadaEspecial(int numSorte) {
        controller.fazJogadaEspecial(numSorte);
    }

    public void sacar(double val) {
        boolean cons = false;
        do {
            if (controller.saldo() <= val) {
                controller.sacar(val);
                cons = true;
            } else {
                this.emprestimo(Double.valueOf(JOptionPane.showInputDialog("Você precisa realizar um saque!"
                        + " \nDigite o valor do empréstimo")));
            }
        } while (cons == false);

    }

    public void fazAcao(String numOpcao) {

        switch (numOpcao) {

            case "1":
            case "11":
            case "19":
            case "22":
                Stack<Correios> cor = controller.retiraCartaCorreio(1);
                controller.fazJogadaCorreio(cor, compras, control);
                break;

            case "5":
            case "24":
                Stack<Correios> cor2 = controller.retiraCartaCorreio(2);
                controller.fazJogadaCorreio(cor2, compras, control);
                break;

            case "3":
            case "16":
                Stack<Correios> cor3 = controller.retiraCartaCorreio(3);
                controller.fazJogadaCorreio(cor3, compras, control);
                break;
            case "2":
                controller.fazJogadaPremio();

                break;

            case "6":
            case "13":
            case "20":
            case "27":

                /**
                 * Recebe a quantidade de jogadores, multiplica por 100, soma
                 * com 1000 do banco, e espera os jogadores jogarem o dado, o
                 * primeiro que tirar 3 recebe o valor total do bolão. esboço
                 * 1:.
                 *
                 * this.jogadaBolao(qtdJogadores);
                 *
                 * public void jogadaBolao(int qtdJogadores, Jogador vencedor){
                 * int totalBolao = qtdJogadores*100;
                 * vencedor.depositar(totalBolao); } o parametro recebido é a
                 * quantidade de jogadores que vão participar.
                 *
                 */
                int qtdJog = 0;
                int op = JOptionPane.showConfirmDialog(null, "Deseja participar do Bolão");
                if (op == 0) {
                    try {
                        control.mandaAll("B@Z");
                    } catch (IOException ex) {
                        System.out.println("deu ruim ");
                    }
                }

                if (op == 0) {
                    controller.fazJogadaBolao(qtdJog, true);
                }
                break;
            case "7":
            case "14":
            case "18":
            case "28":
                /**
                 * Em todos esses casos deve ser depositado um valor específico
                 * no sorte grande, caso não tenha dinheiro é necessário pedir
                 * empréstimo, e ficou padronizado para que seja todos o mesmo
                 * valor. Esboço:.
                 *
                 * public void fazJogadaDiversao(Jogador jog){
                 *
                 * if(jog.getSaldo() menor ou igual 100 ){
                 *
                 * sg = jog.sacar(100); } else throw new
                 * SaldoRuimException("Saldo insuficiente, peça um empréstimo");
                 * } .
                 *
                 */
                try {
                    controller.fazJogadaDiversao();
                } catch (SaldoRuimException e) {
                    JOptionPane.showInputDialog("Peça um empréstimo! Digite o valor abaixo");
                }
                break;
            case "4":
            case "12":
            case "15":
            case "25":
                /**
                 * Compras e entretenimento. Nesse método o cliente tira uma
                 * carta e escolhe se quer comprar ou não. Se ele quiser, a
                 * carta é adicionada na lista de cartas dele.
                 */
                ComprasEnt ce;
                ce = controller.retiraCartaEnt();

                int desejo = JOptionPane.showConfirmDialog(null, "Deseja comprar "
                        + ce.especificaCarta() + " por: " + String.valueOf(ce.valorCompraCarta()) + "?"
                        + "\nValor da Venda: " + String.valueOf(ce.valorVendaCarta()));

                if (desejo == 0) {
                    System.out.println("Chegou na hora certa!");
                    boolean foi = false;
                    do {
                        if (ce.valorCompraCarta() <= controller.saldo()) {
                            foi = true;
                            compras.add(ce);
                            controller.sacar(ce.valorCompraCarta());
                        } else {
                            controller.emprestimo(Double.valueOf(JOptionPane.showInputDialog("Você não tem saldo, Digite o valor do emprestimo")));
                        }
                    } while (foi == false);

                }
                break;
            case "9":
            case "17":
            case "23":
            case "26":
            case "29":
                /**
                 * Achou comprador.
                 */
                JButton dado,
                 b1,
                 b2,
                 b3,
                 b4;
                JPanel p1,
                 p2,
                 p3,
                 p4,
                 geral;
                JLabel l1,
                 l2;
                JFrame frame;

                JOptionPane.showMessageDialog(null, "Você está na casa achou comprador");
                if (compras.empty()) {
                    JOptionPane.showMessageDialog(null, "Desculpe, você não possui itens para vender!");
                } else {
                    frame = new JFrame();
                    p1 = new JPanel();
                    p2 = new JPanel();
                    p3 = new JPanel();
                    p4 = new JPanel();
                    geral = new JPanel(new GridLayout(2, 2));
                    l1 = new JLabel("Escolha qual item deseja vender");
                    b1 = new JButton("Vender Moto");
                    b2 = new JButton("Vender Carro");
                    b3 = new JButton("Vender Iate");
                    b4 = new JButton("Vender Casa");

                    boolean moto = false, iate = false, carro = false, casa = false;
                    Stack<ComprasEnt> aux = new Stack();
                    ComprasEnt aux2;
                    for (int i = 0; i < compras.size(); i++) {
                        aux2 = compras.pop();
                        if (aux2 instanceof Moto) {
                            moto = true;
                            aux.add(aux2);
                        } else if (aux2 instanceof Iate) {
                            iate = true;
                            aux.add(aux2);
                        } else if (aux2 instanceof Carro) {
                            carro = true;
                            aux.add(aux2);
                        } else if (aux2 instanceof Casa) {
                            casa = true;
                            aux.add(aux2);
                        }

                    }
                    for (int j = 0; j < aux.size(); j++) {
                        compras.add(aux.pop());
                    }
                    if (moto == true) {
                        p1.add(b1, BorderLayout.CENTER);
                        b1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                controller.fazJogadaEnt("2", compras);
                                frame.dispose();
                            }

                        });
                    }
                    if (carro == true) {
                        p2.add(b2, BorderLayout.CENTER);
                        b2.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                controller.fazJogadaEnt("4", compras);
                                frame.dispose();
                            }

                        });
                    }
                    if (iate == true) {
                        p3.add(b3, BorderLayout.CENTER);
                        b3.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                controller.fazJogadaEnt("3", compras);
                                frame.dispose();
                            }

                        });
                    }
                    if (casa == true) {
                        p4.add(b4, BorderLayout.CENTER);
                        b4.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                controller.fazJogadaEnt("1", compras);
                                frame.dispose();
                            }

                        });
                    }
                    geral.add(p1);
                    geral.add(p2);
                    geral.add(p3);
                    geral.add(p4);

                    frame.add(l1, BorderLayout.NORTH);
                    frame.add(geral, BorderLayout.CENTER);
                    frame.setDefaultCloseOperation(2);
                    frame.setLocationRelativeTo(null);
                    frame.setSize(400, 300);
                    frame.setVisible(true);
                }
                break;

            case "8":
                //Concurso de Banda de Arrocha.
                /**
                 * Esse numero que está sendo passado é numero do dado, além
                 * disso precisamos criar uma variável que indique se é a vez do
                 * jogador.
                 */
                //int numDado = 0;
                //controller.fazJogadaArrocha(numDado);
                frame = new JFrame();
                dado = new JButton("Jogar Dado");
                l1 = new JLabel("Você está participando do concurso de banda de arrocha.");
                dado.setSize(15, 30);
                p1 = new JPanel();
                p2 = new JPanel();
                p3 = new JPanel(new GridLayout(2, 1));
                l2 = new JLabel();

                p1.add(l2, BorderLayout.NORTH);
                p1.add(dado);
                p2.add(l1);
                p3.add(p2);
                p3.add(p1, BorderLayout.SOUTH);

                dado.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        /**
                         * Chamar o método de concurso arrocha, e passar a
                         * jogada pra todos, após isso, ele tem também que
                         * chamar o próximo jogador caso o que jogou não tenha
                         * vencido o concurso.
                         */
                        cont++;
                        if (cont == 1) {
                            Random r = new Random();
                            int dado = r.nextInt(6) + 1;
                            boolean ganhou = controller.fazJogadaArrocha(dado);
                            l2.setText("Número sorteado: " + dado);

                            if (ganhou == true) {
                                JOptionPane.showMessageDialog(null, "Parabéns você ganhou o concurso \n "
                                        + "e recebeu 1000");

                            } else {
                                JOptionPane.showMessageDialog(null, "Você não ganhou o prêmio :-(");
                                try {
                                    //Chamar o método de proximo jogador, e zera o dado 
                                    Jogadores tt = (Jogadores) control.listaJogadores().get(ControllerConexao.contadorPosicao);
                                    control.manda("JA", tt.getNick());
                                    cont = 0;
                                } catch (IOException ex) {
                                    Logger.getLogger(Cont.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Você ja jogou o dado!");
                        }
                        frame.dispose();
                    }
                });

                frame.add(p3, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(2);
                frame.setSize(450, 300);
                frame.setTitle("Concurso de Arrocha");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                break;
            case "10":
                //Feliz aniversário.   
                JOptionPane.showMessageDialog(null, "Você caiu na casa Aniversário");

                try {
                    control.mandaAll("SA@100");
                } catch (IOException ex) {
                    Logger.getLogger(Cont.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ControllerConexao.mens.equals("SA")) {
                    this.sacar(ControllerConexao.valor);
                }

                qtdJog = (control.listaJogadores().size() - 1);
                System.out.println("Vamo ver " + qtdJog);
                controller.fazJogadaAniver(qtdJog);
                break;
            case "21":
                //Negocio de ocasião
                frame = new JFrame();
                dado = new JButton("Jogar Dado");
                l1 = new JLabel("Você caiu no negócio de ocasião.");
                dado.setSize(15, 30);
                p1 = new JPanel();
                p2 = new JPanel();
                p3 = new JPanel(new GridLayout(2, 1));
                l2 = new JLabel();

                p1.add(l2, BorderLayout.NORTH);
                p1.add(dado);
                p2.add(l1);
                p3.add(p2);
                p3.add(p1, BorderLayout.SOUTH);

                dado.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        Random r = new Random();
                        int dado = r.nextInt(6) + 1;
                        l2.setText("Número sorteado: " + dado);
                        boolean fez = false;
                        do {
                            try {
                                fez = controller.fazJogadaNegocio(dado, compras);
                            } catch (SaldoRuimException d) {
                                controller.emprestimo(Double.valueOf(JOptionPane.showInputDialog("Você precisa comprar a carta, então peça um emprestimo!")));
                            }
                        } while (fez == false);
                    }
                });

                frame.add(p3, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(2);
                frame.setSize(450, 300);
                frame.setTitle("Negocio de ocasião");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                break;
            case "30":
                //Maratona.
                JOptionPane.showMessageDialog(null, "você está na maratona Beneficente");

                try {
                    control.mandaAll("MA");
                } catch (IOException ex) {
                    Logger.getLogger(Cont.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (ControllerConexao.mens.equals("MA")) {

                    frame = new JFrame();
                    dado = new JButton("Jogar Dado");
                    l1 = new JLabel("Você está participando da maratona Beneficente.");
                    dado.setSize(15, 30);
                    p1 = new JPanel();
                    p2 = new JPanel();
                    p3 = new JPanel(new GridLayout(2, 1));
                    l2 = new JLabel();

                    p1.add(l2, BorderLayout.NORTH);
                    p1.add(dado);
                    p2.add(l1);
                    p3.add(p2);
                    p3.add(p1, BorderLayout.SOUTH);

                    dado.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Random r = new Random();
                            int dado = r.nextInt(6) + 1;
                            l2.setText("Número sorteado: " + dado);
                            controller.fazJogadaMaratona(dado);
                            frame.dispose();
                        }

                    });

                    frame.add(p3, BorderLayout.CENTER);
                    frame.setDefaultCloseOperation(2);
                    frame.setSize(450, 300);
                    frame.setTitle("Maratona");
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
                break;
            case "31":
                /**
                 * Dia de Mesada, retira um valor de 3500.
                 */
                boolean fez = false;
                do {
                    try {
                        JOptionPane.showMessageDialog(null, "Você chegou no dia da mesada!");
                        fez = controller.diaMesada();
                    } catch (SaldoRuimException e) {
                        controller.emprestimo(Double.valueOf(JOptionPane.showInputDialog("você tem que pedir empréstimo!\nDigite o valor do empréstimo")));
                    }
                } while (fez == false);

                break;

        }
    }
    //Fim do método faz ação.
}
