/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Excecoes.SaldoRuimException;
import Model.Carro;
import Model.Casa;
import Model.CobrancaMonstro;
import Model.ComprasEnt;
import Model.Contas;
import Model.Correios;
import Model.DinheiroExtra;
import Model.Doacao;
import Model.FormaBaralho;
import Model.Iate;
import Model.Moto;
import Model.PagueVizinho;
import Model.VaParaFrente;
import ModelBanco.Conta;
import ModelBanco.SorteGrande;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Emanuel Santana
 */
public class Cont2 {

    private Stack<Correios> corre;
    private Stack<ComprasEnt> compras;
    private Stack<ComprasEnt> compraAux;
    private FormaBaralho forma;
    private double valorDevido;
    private int casa;

    private Conta co;
    private Conta jog2;
    private SorteGrande sg;
    //private Cont controller;
    //private Stack<ComprasEnt> listCartasEnt;
    private String boraLa;
    private JFrame frame = new JFrame();

    public Cont2() {
        corre = new Stack();
        compras = new Stack();
        compraAux = new Stack();
        forma = new FormaBaralho();
        corre = forma.fazerBaralhoCorreio();
        co = new Conta(1000, "Emanuel");
        jog2 = new Conta(3000, "Jogador 2");
        sg = new SorteGrande();
        //listCartasEnt = new Stack();

    }

    /**
     *
     * @param numCartas
     * @return
     */
    public Stack<Correios> retiraCartaCorreio(int numCartas) {

        Stack<Correios> aux = new Stack();

        if (corre.empty() || corre.size() < numCartas) {
            System.out.println("Tava vazio");
            corre = forma.fazerBaralhoCorreio();

            for (int i = 0; i < numCartas; i++) {
                aux.push(corre.pop());
            }
        } else {

            for (int i = 0; i < numCartas; i++) {
                aux.push(corre.pop());
            }

        }
        return aux;
    }

    public void sacar(double valor) {
        jog2.sacar(valor);
    }

    /**
     *
     * @return
     */
    public ComprasEnt retiraCartaEnt() {

        if (compras.empty()) {
            compras = forma.fazerBaralhobEnt();
            return compras.pop();

        } else {
            return compras.pop();
        }

    }

    /**
     * Esse método recebe a opção do tipo de carta que o cliente deseja vender.
     * Além de receber a conta do usuário na qual o valor vai ser depositado.
     * Esse laço vê o tamanho da pilha de cartas do tipo Compras e
     * Entretenimento que o cliente possui, e como cada opção representa um tipo
     * de carta esse laço percorre a pilha procurando a primeira carta do tipo
     * desejado. Ao encontrar a carta ela tem seu valor adicionado na conta do
     * cliente, e o laço é interrompido. Após a interrupção do laço as cartas
     * que haviam sido retiradas da pilha, mas que não eram do tipo desejado,
     * são retornadas a pilha original de cartas.
     *
     * @param opCarta, recebe o tipo de carta que o cliente deseja vender.
     * @param listCartasEnt, recebe a lista de cartas que o cliente possui.
     */
    public void fazJogadaEnt(String opCarta, Stack<ComprasEnt> listCartasEnt) {
        ComprasEnt aux2;  //Variável auxiliar para ajudar no processo de venda.
        Stack<ComprasEnt> compAux = new Stack();  //Pilha auxiliar 

        if (listCartasEnt.empty() == false) {
            switch (opCarta) {
                case "1":

                    for (int i = 0; i < listCartasEnt.size(); i++) {

                        aux2 = listCartasEnt.pop();
                        if (aux2 instanceof Casa) {
                            jog2.depositar(aux2.valorVendaCarta());
                            break;
                        } else {
                            compAux.add(aux2);
                        }
                    }
                    if (compAux.size() > 0) {
                        for (int i = 0; i < compAux.size(); i++) {
                            listCartasEnt.add(compAux.pop());
                        }
                    }
                    break;
                case "2":
                    for (int i = 0; i < listCartasEnt.size(); i++) {

                        aux2 = listCartasEnt.pop();
                        if (aux2 instanceof Moto) {
                            jog2.depositar(aux2.valorVendaCarta());
                            break;
                        } else {
                            compAux.add(aux2);
                        }
                    }
                    if (compAux.size() > 0) {
                        for (int i = 0; i < compAux.size(); i++) {
                            listCartasEnt.add(compAux.pop());
                        }
                    }
                    break;
                case "3":
                    for (int i = 0; i < listCartasEnt.size(); i++) {

                        aux2 = listCartasEnt.pop();
                        if (aux2 instanceof Iate) {
                            jog2.depositar(aux2.valorVendaCarta());
                            break;
                        } else {
                            compAux.add(aux2);
                        }
                    }
                    if (compAux.size() > 0) {
                        for (int i = 0; i < compAux.size(); i++) {
                            listCartasEnt.add(compAux.pop());
                        }
                    }
                    break;
                default:
                    for (int i = 0; i < listCartasEnt.size(); i++) {

                        aux2 = listCartasEnt.pop();
                        if (aux2 instanceof Carro) {
                            jog2.depositar(aux2.valorVendaCarta());
                            break;
                        } else {
                            compAux.add(aux2);
                        }
                    }
                    if (compAux.size() > 0) {
                        for (int i = 0; i < compAux.size(); i++) {
                            listCartasEnt.add(compAux.pop());
                        }
                    }
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Desculpe, você não tem cartas entretenimento para vender");
        }

    }

    /**
     *
     * @return
     *
     * public ComprasEnt retCartaEnt() { ComprasEnt aux2 = null;
     * Stack<ComprasEnt> compAux = new Stack(); for (int i = 0; i < listCartasEnt.size(); i++) {
     *
     * aux2 = listCartasEnt.pop();
     * if (aux2 instanceof Casa) {
     * break;
     * } else {
     * compAux.add(aux2);
     * }
     * }
     * if (compAux.size() > 0) { for (int i = 0; i < compAux.size(); i++) {
     * listCartasEnt.add(compAux.pop()); } } return aux2; }
     */
    /**
     *
     * @param numDado
     * @return
     */
    public boolean fazJogadaArrocha(int numDado) {

        if (numDado == 3) {
            jog2.depositar(1000);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param op
     * @param jog
     * @param carta
     * @return
     * @throws SaldoRuimException
     */
    public boolean fazJogadaConta(String op, Conta jog, Contas carta) throws SaldoRuimException {

        if (op.trim().equals("0")) {
            if (carta.valorCarta() <= jog.getSaldo()) {
                sg.adicionarTotal(jog.sacar(carta.valorCarta()));
                return true;
            } else {
                throw new SaldoRuimException("Saldo insuficiente, pede empréstimo!");
            }
        } else {

            valorDevido = carta.valorCarta();

            return true;
        }

    }

    /**
     *
     * @param contaJog
     * @return
     */
    public boolean fazJogadaDimExtra(Conta contaJog) {

        /**
         * Ao fazer essa jogada deve ser retirado esse mesmo valor do jogador
         * escolhido.
         */
        DinheiroExtra d = new DinheiroExtra();
        contaJog.depositar(d.valorCarta());
        return true;

    }

    /**
     *
     * @param c
     * @return
     */
    public boolean fazJogadaDoacao(Conta c) {

        Doacao d = new Doacao();
        if (d.valorCarta() <= c.getSaldo()) {
            sg.adicionarTotal(d.valorCarta());
            return true;
        } else {
            throw new SaldoRuimException("Saldo insuficiente, faça um empréstimo!");
        }
    }

    /**
     *
     * @param retira
     * @param recebe
     * @return
     */
    public boolean fazJogadaPague(Conta retira) {
        PagueVizinho valorPag = new PagueVizinho();

        if (valorPag.valorCarta() <= retira.getSaldo()) {
            retira.sacar(valorPag.valorCarta());
            return true;
        } else {
            throw new SaldoRuimException("Saldo insuficiente, faça um empréstimo!");
        }

    }

    /**
     *
     * @param qtdJog
     * @param ganhou
     */
    public void fazJogadaBolao(int qtdJog, boolean ganhou) {

        if (ganhou == true) {
            jog2.depositar((qtdJog * 100) + 1000);
        } else {
            jog2.sacar((qtdJog * 100) + 1000);
        }

    }

    /**
     *
     * @param op
     * @return
     */
    public boolean fazCobrancaMonstro(String op) {

        CobrancaMonstro cb = new CobrancaMonstro();
        if (op.equals("0")) {
            if (cb.valorCarta() <= jog2.getSaldo()) {
                jog2.sacar(cb.valorCarta());
                return true;
            } else {
                throw new SaldoRuimException("Saldo insuficiente, faça um empréstimo!");
            }

        } else {
            valorDevido = cb.valorCarta();
            return true;
        }

    }

    /**
     *
     * @return
     */
    public double saldo() {
        return jog2.getSaldo();
    }

    /**
     *
     * @return
     */
    public boolean diaMesada() {

        jog2.depositar(3500);
        jog2.cobraTaxa();

        if (jog2.retJuros() <= jog2.getSaldo()) {

            jog2.sacar(jog2.retJuros());

            if (jog2.valorDevido() <= jog2.getSaldo()) {

                jog2.sacar(jog2.valorDevido());
                int faz = JOptionPane.showConfirmDialog(null, "Deseja pagar o valor total devido?");
                if (faz == 0) {
                    if (jog2.getQuantoDeve() <= jog2.getSaldo()) {
                        jog2.sacar(jog2.getQuantoDeve());
                        return true;
                    } else {
                        throw new SaldoRuimException("Saldo insuficiente, Então faça um empréstimo!");
                    }
                }
                return true;
            } else {
                throw new SaldoRuimException("Saldo insuficiente, Então faça um empréstimo!");
            }
        } else {
            throw new SaldoRuimException("Saldo insuficiente, Então faça um empréstimo!");
        }

    }

    /**
     *
     * @param valor
     */
    public void emprestimo(double valor) {

        jog2.depositar(valor);
        jog2.addValorEmp(valor);

    }

    /**
     *
     * @param num
     * @return
     */
    public String anda(int num) {
        casa = casa + num;
        if (casa < 31) {
            String fim = String.valueOf(casa);
            return fim;
        } else {
            casa = 0;
            return "31";
        }
    }

    /**
     *
     * @return
     */
    public double retDivida() {
        return jog2.getQuantoDeve();
    }

    /**
     *
     */
    public void fazJogadaPremio() {
        jog2.depositar(5000);
        JOptionPane.showMessageDialog(null, "Parabéns, você ganhou 5000");

    }

    public boolean fazJogadaNegocio(int numDado) {
        if ((numDado * 100) <= jog2.getSaldo()) {
            jog2.sacar(numDado * 100);
            compras.add(this.retiraCartaEnt());
            return true;
        } else {
            throw new SaldoRuimException("Saldo insuficiente, peça um emprestimo");
        }
    }

    public void fazJogadaEspecial(int num) {
        if (num == 6) {
            JOptionPane.showMessageDialog(null, "Tirou 6 e ganhou o dinheiro do sorteGrande");
            jog2.depositar(sg.verTotal());
            double valor = sg.verTotal();
            sg.retirarTotal(valor);
        }
        
    }

    /**
     *
     *
     */
    public void fazJogadaDiversao() {

        if (jog2.getSaldo() >= 100) {
            sg.adicionarTotal(jog2.sacar(100));
            JOptionPane.showMessageDialog(null, "Você caiu na jogada diversão e teve que sacar 100");
        } else {
            throw new SaldoRuimException("Saldo insuficiente, peça um empréstimo");
        }
    }

    /**
     *
     * @param cor
     */
    public void fazAcoesGeral(Stack<Correios> cor, Stack<ComprasEnt> compra) {
        // controller = new Cont();
        compraAux = compra;

        for (int i = 0; i < cor.size(); i++) {

            Correios aux = cor.pop();

            if (aux instanceof Contas) {
                boolean enq = false;

                Contas c = (Contas) aux;
                do {
                    try {

                        enq = fazJogadaConta(String.valueOf(JOptionPane.showConfirmDialog(null,
                                "Carta do tipo conta\nDeseja pagar agora?")), jog2, c);
                    } catch (SaldoRuimException e) {
                        emprestimo(Double.valueOf(JOptionPane.showInputDialog("Digite o valor do empréstimo")));
                    }
                } while (enq == false);

            } else if (aux instanceof DinheiroExtra) {
                System.out.println("Dinheiro extra");

                boolean fez = false;
                /*
                 Aqui vai receber a conta da qual vai retirar o dinheiro, e a
                 outra é a que vai receber o dinheiro extra, se ele não tiver o
                 dinheiro, ele não faz a operação.
                 Aqui, é necessário criar uma janela, com a opção dos jogadores
                 todos eles devem estar presentes.
                 */

                JOptionPane.showMessageDialog(null, "A carta é do tipo: Dinheiro extra, ");
                fez = fazJogadaDimExtra(jog2);

            } else if (aux instanceof Doacao) {

                boolean opcao = false;
                do {
                    try {
                        JOptionPane.showMessageDialog(null, "A carta é do tipo doação");
                        opcao = fazJogadaDoacao(jog2);

                    } catch (SaldoRuimException e) {

                        emprestimo(Double.valueOf(JOptionPane.showInputDialog(null,
                                "Você vai ter que pedir emprestimo! quanto deseja?")));
                    }
                } while (opcao == false);

            } else if (aux instanceof PagueVizinho) {
                boolean fez = false;
                do {
                    try {
                        JOptionPane.showMessageDialog(null, "Pague um vizinho");
                        fez = fazJogadaPague(jog2);
                    } catch (SaldoRuimException e) {
                        JOptionPane.showInputDialog("Você precisa pagar, então retire um emprestimo! \nDigite o valor");
                    }

                } while (fez == false);

            } else if (aux instanceof CobrancaMonstro) {
                boolean fez = false;
                do {
                    try {
                        String opcao = String.valueOf(JOptionPane.showConfirmDialog(null,
                                "Cobrança monstro, valor: 400\nDeseja pagar agora?"));
                        fez = fazCobrancaMonstro(opcao);
                    } catch (SaldoRuimException e) {
                        JOptionPane.showInputDialog("Você precisa pagar, então retire um emprestimo! \nDigite o valor");
                    }

                } while (fez == false);

            } else if (aux instanceof VaParaFrente) {

                this.escolheCasa();

            }
        }

    }

    /**
     *
     * @param num
     */
    public void fazJogadaSorteGrande(int num) {
        if (num == 6) {
            jog2.depositar(sg.verTotal());
            sg.retirarTotal(sg.verTotal());
            JOptionPane.showMessageDialog(null, "Parabéns, você ganhou todo o dinheiro do sorte grande");
        }
    }

    /**
     *
     * @param numDado
     */
    public void fazJogadaMaratona(int numDado) {
        sg.adicionarTotal(numDado * 100);
    }

    public void escolheCasa() {

        JPanel p1, p2, p3, p4;
        JButton b1, b2;
        JLabel l1 = new JLabel("Escolha pra qual casa deseja ir");

        b1 = new JButton("Achou Comprador");
        b2 = new JButton("Compras Ent");

        p1 = new JPanel(new GridLayout(3, 1));
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        p2.add(l1);
        p3.add(b1);
        p4.add(b2);
        p1.add(p2);
        p1.add(p3);
        p1.add(p4);
        int jogou = 0;

        if (jogou == 0) {
            fazJogC g = new fazJogC();
            fazJogCe ge = new fazJogCe();

            b1.addActionListener(ge);
            b2.addActionListener(g);
        }
        frame.add(p1);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(2);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    private class fazJogC implements ActionListener {

        String chegou = null;
        int jogou = 0;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (jogou == 0) {
                for (int i = 0; i < 30; i++) {

                    chegou = anda(1);

                    if (chegou.trim().equals("4") || chegou.trim().equals("12") || chegou.equals("15")
                            || chegou.equals("25")) {
                        ComprasEnt ce;
                        ce = retiraCartaEnt();

                        int desejo = JOptionPane.showConfirmDialog(null, "Deseja comprar "
                                + ce.especificaCarta() + " por: " + String.valueOf(ce.valorCompraCarta()) + "?"
                                + "\nValor da Venda: " + String.valueOf(ce.valorVendaCarta()));

                        if (desejo == 0) {
                            System.out.println("Chegou na hora certa!");
                            boolean foi = false;
                            do {
                                if (ce.valorCompraCarta() <= saldo()) {
                                    foi = true;
                                    compras.add(ce);
                                    sacar(ce.valorCompraCarta());
                                } else {
                                    emprestimo(Double.valueOf(JOptionPane.showInputDialog("Você não tem saldo, Digite o valor do emprestimo")));
                                }
                            } while (foi == false);

                        }
                        break;
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Você ja escolheu a casa!");
            }

        }
    }

    private class fazJogCe implements ActionListener {

        String chegou = null;
        int jogou = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jogou == 0) {
                for (int i = 0; i < 30; i++) {

                    chegou = anda(1);

                    if (chegou.equals("9") || chegou.equals("17") || chegou.equals("23")
                            || chegou.equals("26") || chegou.equals("27")) {
                        JOptionPane.showMessageDialog(null, "Você está na casa achou comprador");
                        if (compras.empty()) {

                            JOptionPane.showMessageDialog(null, "Desculpe, você não possui itens para vender!");
                        } else {
                            JPanel p1, p2, p3, p4, geral;
                            JButton b1, b2, b3, b4;
                            JLabel l1;
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
                            for (int j = 0; j < compraAux.size(); j++) {
                                aux2 = compraAux.pop();
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
                                compraAux.add(aux.pop());
                            }
                            if (moto == true) {
                                p1.add(b1, BorderLayout.CENTER);
                                BotaoMoto mo = new BotaoMoto();
                                b1.addActionListener(mo);
                            }
                            if (carro == true) {
                                p2.add(b2, BorderLayout.CENTER);
                                BotaoCarro cr = new BotaoCarro();
                                b2.addActionListener(cr);
                            }
                            if (iate == true) {
                                p3.add(b3, BorderLayout.CENTER);
                                BotaoIate ia = new BotaoIate();
                                b3.addActionListener(ia);
                            }
                            if (casa == true) {
                                p4.add(b4, BorderLayout.CENTER);
                                BotaoCasa ca = new BotaoCasa();
                                b4.addActionListener(ca);
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
                    }
                    System.out.println("Saiu essa casa" + chegou);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Você ja escolheu a casa!");
            }
        }

    }

    private class BotaoMoto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fazJogadaEnt("2", compraAux);
        }
    }

    private class BotaoIate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fazJogadaEnt("3", compraAux);
        }
    }

    private class BotaoCarro implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fazJogadaEnt("4", compraAux);
        }
    }

    private class BotaoCasa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fazJogadaEnt("1", compraAux);
        }
    }

}
