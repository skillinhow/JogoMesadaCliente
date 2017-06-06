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
    private FormaBaralho forma;
    private int casa;
    private Conta jog2;
    private SorteGrande sg;

    public Cont2() {
        corre = new Stack();
        compras = new Stack();
        forma = new FormaBaralho();
        corre = forma.fazerBaralhoCorreio();
        jog2 = new Conta(3000, "Jogador 2");
        sg = new SorteGrande();

    }

    /**
     * Este método é responsável por realizar saques na conta do cliente.
     *
     * @param valor, este é o valor a ser retirado.
     */
    public void sacar(double valor) {
        jog2.sacar(valor);
    }

    public SorteGrande tiraDuvida() {
        return sg;
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
     * Quando este método é chamado significa que o cliente caiu em uma casa do
     * tipo correios, e então é necessário cumprir o que a carta especifica.
     *
     * @param numCartas, representa a quantidade de cartas que o cliente retirou
     * nesta casa.
     * @return a lista de cartas do tipo correio que o cliente vai utilizar.
     */
    public Stack<Correios> retiraCartaCorreio(int numCartas) {

        Stack<Correios> aux = new Stack();
        //Pilha auxiliar para ajudar no processo.

        /*
         Verifica se a pilha de cartas do cliente está vazia, ou se a quantidade 
         de cartas que o cliente necessita é maior do que o tamanho da pilha, 
         ou seja, se há cartas suficiente no baralho, se houverem cartas suficiente
         e a pilha não estiver vazia, ele adiciona as cartas na pilha do cliente, 
         e então retorna essa pilha.
        
         */
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

    /**
     * Ao cair em uma casa do compras e entretenimento,
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

    public void fazJogadaAniver(int numJog) {

        int total = 0;
        total = total + (numJog * 100);
        jog2.depositar(total);

    }

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
     * @param qtdJog
     * @param ganhou
     */
    public void fazJogadaBolao(int qtdJog, boolean ganhou) {

        if (ganhou == true) {
            jog2.depositar((qtdJog * 100) + 1000);
        } else {
            jog2.sacar(100);
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
            jog2.addValorDevido(cb.valorCarta());
            return true;
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
                jog.sacar(carta.valorCarta());
                sg.adicionarTotal(carta.valorCarta());
                return true;
            } else {
                throw new SaldoRuimException("Saldo insuficiente, pede empréstimo!");
            }
        } else {
            jog2.addValorDevido(carta.valorCarta());
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
     * @return
     */
    public boolean diaMesada() {

        jog2.depositar(3500);
        jog2.cobraTaxa();

        if (jog2.retJuros() <= jog2.getSaldo()) {

            jog2.sacar(jog2.retJuros());

            if (jog2.valorDevido() <= jog2.getSaldo()) {

                jog2.sacar(jog2.valorDevido());
                jog2.pagarValor(jog2.valorDevido());

                int faz = JOptionPane.showConfirmDialog(null, "Deseja pagar o valor total devido?");

                if (faz == 0) {
                    if (jog2.getQuantoDeve() <= jog2.getSaldo()) {
                        JOptionPane.showMessageDialog(null, "Todas as dívidas foram pagas");
                        jog2.sacar(jog2.getQuantoDeve());
                        jog2.pagarEmprestimo(jog2.getQuantoDeve());
                        return true;
                    } else {
                        throw new SaldoRuimException("Saldo insuficiente, Então faça um empréstimo!");
                    }
                } else {
                    return true;
                }
            } else {
                throw new SaldoRuimException("Saldo insuficiente, Então faça um empréstimo!");
            }
        } else {
            throw new SaldoRuimException("Saldo insuficiente, Então faça um empréstimo!");
        }

    }

    /**
     *
     *
     */
    public void fazJogadaDiversao() {

        if (100 <= jog2.getSaldo()) {
            jog2.sacar(100);
            sg.adicionarTotal(100);
            JOptionPane.showMessageDialog(null, "Você caiu na jogada diversão e teve que sacar 100");
        } else {
            throw new SaldoRuimException("Saldo insuficiente, peça um empréstimo");
        }
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

    public void fazJogadaEspecial(int num) {
        if (num == 6) {
            JOptionPane.showMessageDialog(null, "Tirou 6 e ganhou o dinheiro do sorteGrande");
            int valor = (int) sg.verTotal();
            jog2.depositar(valor);
            sg.retirarTotal(valor);
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
                            JOptionPane.showMessageDialog(null, "Casa vendida com sucesso");
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
                            JOptionPane.showMessageDialog(null, "Moto vendida com sucesso");
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
                            JOptionPane.showMessageDialog(null, "Iate vendido com sucesso");
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
                            JOptionPane.showMessageDialog(null, "Carro vendido com sucesso");
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
     * @param numDado
     */
    public void fazJogadaMaratona(int numDado) {
        sg.adicionarTotal((numDado * 100));
    }

    public boolean fazJogadaNegocio(int numDado, Stack<ComprasEnt> cart) {
        int resultado = 0;
        resultado = resultado + (numDado * 100);
        if (resultado <= jog2.getSaldo()) {
            JOptionPane.showMessageDialog(null, "Parabéns, você acaba de ganhar uma"
                    + " carta entretenimento por: " + "\n" + resultado);
            jog2.sacar(resultado);
            cart.add(retiraCartaEnt());
            return true;
        } else {
            throw new SaldoRuimException("Saldo insuficiente, peça um emprestimo");
        }
    }

    /**
     *
     * @param retira
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
     */
    public void fazJogadaPremio() {
        jog2.depositar(5000);
        JOptionPane.showMessageDialog(null, "Parabéns, você ganhou 5000");

    }

    /**
     *
     * @param cor
     * @param compra
     */
    public void fazJogadaCorreio(Stack<Correios> cor, Stack<ComprasEnt> compra) {

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

                /*
                 Aqui vai receber a conta da qual vai retirar o dinheiro, e a
                 outra é a que vai receber o dinheiro extra, se ele não tiver o
                 dinheiro, ele não faz a operação.
                 Aqui, é necessário criar uma janela, com a opção dos jogadores
                 todos eles devem estar presentes.
                 */
                JOptionPane.showMessageDialog(null, "A carta é do tipo: Dinheiro extra, ");
                fazJogadaDimExtra(jog2);

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
                        emprestimo(Double.valueOf(JOptionPane.showInputDialog("Você precisa pagar, então retire um emprestimo! \nDigite o valor")));
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
                        emprestimo(Double.valueOf(JOptionPane.showInputDialog("Você precisa pagar, então retire um emprestimo! \nDigite o valor")));
                    }

                } while (fez == false);

            } else if (aux instanceof VaParaFrente) {

                escolheCasa(compra);

            }
        }

    }

    public void escolheCasa(Stack<ComprasEnt> compraAux) {

        JFrame frame = new JFrame();
        JPanel pp1, pp2, pp3, pp4;
        JButton bb1, bb2;
        JLabel ll1 = new JLabel("Escolha pra qual casa deseja ir");

        bb1 = new JButton("Achou Comprador");
        bb2 = new JButton("Compras Ent");

        pp1 = new JPanel(new GridLayout(3, 1));
        pp2 = new JPanel();
        pp3 = new JPanel();
        pp4 = new JPanel();

        pp2.add(ll1);
        pp3.add(bb1);
        pp4.add(bb2);
        pp1.add(pp2);
        pp1.add(pp3);
        pp1.add(pp4);
        int jogou = 0;

        if (jogou == 0) {

            bb1.addActionListener(new ActionListener() {
                String chegou = null;

                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean encontrou = false;
                    frame.dispose();
                    if (jogou == 0) {
                        for (int i = 0; i < 30; i++) {

                            chegou = anda(1);

                            if (chegou.equals("9") || chegou.equals("17") || chegou.equals("23")
                                    || chegou.equals("26") || chegou.equals("27")) {
                                encontrou = true;
                                break;
                            }
                            System.out.println("Saiu essa casa" + chegou);
                        }
                        if (encontrou == true) {
                            JOptionPane.showMessageDialog(null, "Você está na casa achou comprador");
                            if (compraAux.empty()) {

                                JOptionPane.showMessageDialog(null, "Desculpe, você não possui itens para vender!");
                            } else {
                                JFrame frame;
                                JPanel p1, p2, p3, p4, geral;
                                JButton b1, b2, b3, b4;
                                JLabel l1;
                                frame = new JFrame("Escolhe casa");
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
                                    b1.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            fazJogadaEnt("2", compras);
                                            frame.dispose();
                                        }

                                    });
                                }
                                if (carro == true) {
                                    p2.add(b2, BorderLayout.CENTER);
                                    b2.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            fazJogadaEnt("4", compras);
                                            frame.dispose();
                                        }

                                    });
                                }
                                if (iate == true) {
                                    p3.add(b3, BorderLayout.CENTER);
                                    b3.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            fazJogadaEnt("3", compras);
                                            frame.dispose();
                                        }

                                    });
                                }
                                if (casa == true) {
                                    p4.add(b4, BorderLayout.CENTER);
                                    b4.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            fazJogadaEnt("1", compras);
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

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Você ja escolheu a casa!");
                    }
                }

            });

            bb2.addActionListener(new ActionListener() {
                String chegou = null;

                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
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
                                            compraAux.add(ce);
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

            });
        }
        frame.add(pp1);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(2);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    //Fim do método escolhe casa.

}
