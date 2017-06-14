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
import java.io.IOException;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pbl2cliente.ControllerConexao;
import pbl2cliente.Jogadores;

/**
 * Essa é classe que contem a maioria dos métodos do jogo.
 *
 * @author Emanuel Santanae thelu
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

    /**
     * Método que retorna uma variável do tipo sorte grande para que possa ser
     * utilizada em outras classes.
     *
     * @return variável do tipo sorte grande.
     */
    public SorteGrande tiraDuvida() {
        return sg;
    }

    /**
     * Método responsável por retornar o saldo do jogador.
     *
     * @return saldo do jogador.
     */
    public double saldo() {
        return jog2.getSaldo();
    }

    /**
     * Deposita um valor específico na conta do cliente.
     *
     * @param valor total desejado a ser depositado na conta do jogador.
     */
    public void depositar(double valor) {
        jog2.depositar(valor);
    }

    /**
     * Método que realiza empréstimo, ao indicar o valor cliente deposita o
     * valor na conta e também na dívida do cliente.
     *
     * @param valor representa o valor do empréstimo.
     */
    public void emprestimo(double valor) {

        jog2.depositar(valor);
        jog2.addValorEmp(valor);

    }

    /**
     * Método responsável por fazer o jogador andar nas casas do tabuleiro,
     * verifica em qual casa o cliente está, recebe um número e atualiza a casa
     * atual do jogador.
     *
     * @param num número que o cliente tirou no dado.
     * @return a casa atual do jogador.
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
     * Esse método retorna a dívida atual do jogador.
     *
     * @return divida do jogador.
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
     * Ao chegar em uma casa compras e entretenimento, você tem a opção de
     * comprar uma carta desse tipo, esse método retira a carta do baralho e
     * retorna para o cliente.
     *
     * @return carta entretenimento retirada do baralho.
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
     * Ao chegar na casa aniversário, é necessário receber de cada jogador 100
     * reais, então esse método recebe a quantidade de jogadores que há no jogo
     * e então deposita o valor correspondente na conta do jogador contemplado.
     *
     * @param numJog número de jogadores que estão participando da partida.
     */
    public void fazJogadaAniver(int numJog) {

        int total = 0;
        total = total + (numJog * 100);
        jog2.depositar(total);

    }

    /**
     * Ao chegar na casa concurso de banda de arrocha, o cliente tem que jogar o
     * dado se sair o número 3, o cliente ganha 1000, se não outro jogador tem a
     * oportunidade de jogar o dado.
     *
     * @param numDado número que saiu no dado após ele ser jogado.
     * @return falso se o cliente não ganhou o concurso, e true caso contrário.
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
     * Método responsável por fazer apenas o acréscimo na conta do jogador caso
     * ele vença.
     *
     * @param qtdJog quantidade de jogadores que vão participar do bolão.
     * @param ganhou diz se o jogador ganhou o bolão.
     */
    public void fazJogadaBolao(int qtdJog, boolean ganhou) {

        if (ganhou == true) {
            jog2.depositar((qtdJog * 100) + 1000);
        } else {
            jog2.sacar(100);
        }

    }

    /**
     * Método responsável por fazer a cobrança monstro.
     *
     * @param op recebe dizendo se o cliente quer pagar agora.
     * @return retorna true ou false para dizer se fez a operação
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
     * Esse método é responsável por realizar o pagamento da carta do tipo conta
     * ou então adicionar o valor dessa carta no valor de cartas devido pelo
     * cliente.
     *
     * @param op opção para saber se o jogador deseja pagar a carta agora.
     * @param jog conta da qual o dinheiro vai ser retirado.
     * @param carta parâmetro utilizado para saber o valor a ser sacado do
     * jogador.
     * @return true ou false para dizer se fez a operação.
     * @throws SaldoRuimException se for retornada essa exceçao, significa que o
     * jogador não tem saldo suficiente para completar a operação.
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
     * Nesse método é depositado na conta do jogador um valor específico.
     *
     * @param contaJog conta na qual vai ser depositado o dinheiro.
     * @return true ou false para o cliente saber se conseguiu fazer a operação.
     */
    public boolean fazJogadaDimExtra(Conta contaJog) {

        /*
         Ao fazer essa jogada deve ser retirado esse mesmo valor do jogador
         escolhido.
         */
        DinheiroExtra d = new DinheiroExtra();
        contaJog.depositar(d.valorCarta());
        return true;

    }

    /**
     * Aqui o jogador tem que pagar suas dívidas então é depositado um valor de
     * 3500 em sua conta, logo após é cobrado os juros dos emprestimos, logo
     * após o valor das cartas devido.
     *
     * @return true ou false para saber se conseguiu realizar a operação.
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
     * Aqui é feito um saque de 100 na conta do jogador, caso ele não possua
     * saldo suficiente, é necessário que faça um empréstimo.
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
     * Aqui o jogador tem que fazer uma doação ao sorte grande, então é sacado
     * um valor da sua conta, caso ee não possua saldo é necessário trealizar um
     * empréstimo.
     *
     * @param c conta a ser retirado o valor.
     * @return true ou false para saber se conseguiu realizar a operação.
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
     * Cada vez que o jogador jogar o dado ele pode ganhar todo o dinheiro do
     * sorte grande. Para isso ele só precisa tirar 6 no dado.
     *
     * @param num número sorteado no dado.
     */
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
     * Aqui o jogador precisa depositar um valor no sorte grande.
     *
     * @param numDado número a ser multiplicado por 100, para ser depositado no
     * sorte grande esse valor representa o número que saiu no dado.
     */
    public void fazJogadaMaratona(int numDado) {
        sg.adicionarTotal((numDado * 100));
    }

    /**
     * Aqui o cliente pode comprar uma carta por um valor menor.
     *
     * @param numDado número que saiu no dado.
     * @param cart lista de cartas entretenimento do jogador
     * @return true ou false para dizer se conseguiu realizar a operação.
     */
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
     * Aqui só é retirado o valor especificado pela carta, da conta do jogador.
     *
     * @param retira valor a ser retirado.
     * @return true ou false para mostrar se foi feita a operação.
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
     * Método que deposita 5000 caso o jogador caia na casa 2.
     */
    public void fazJogadaPremio() {
        jog2.depositar(5000);
        JOptionPane.showMessageDialog(null, "Parabéns, você ganhou 5000");

    }

    /**
     * Aqui o jogador realiza as operações das cartas correios, realiza as ações
     * a quantidade de vezes de acordo com o número de cartas que ele possui.
     *
     * @param cor lista de cartas do tipo correios que o jogador possui.
     * @param compra lista de cartas do tipo compras e entretenimento que o
     * jogador possui, pois há métodos onde o cliente pode andar e realizar
     * operações.
     * @param control variável controller conexao que possibilita a comunicacao
     * direta com um jogador, aqui ele pode enviar para outros jogadores.
     */
    @SuppressWarnings("empty-statement")
    public void fazJogadaCorreio(Stack<Correios> cor, Stack<ComprasEnt> compra, ControllerConexao control) {

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
                JFrame frame = new JFrame();
                JPanel pp1, pp2, pp3;
                JButton bb1;
                JComboBox cb;

                Vector v = new Vector();
                for (int k = 0; k < control.listaJogadores().size(); k++) {
                    if (control.minhasInfomacoes().getLocalPort() != Integer.parseInt(((Jogadores) control.listaJogadores().get(k)).getPorta())) {
                        v.add(((Jogadores) control.listaJogadores().get(k)).getNick());
                    }
                }
                cb = new JComboBox(v);

                bb1 = new JButton("Confirmar");
                bb1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        try {
                            control.manda("SA@500", cb.getSelectedItem().toString());
                        } catch (IOException ex) {
                            Logger.getLogger(Cont2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                pp1 = new JPanel(new GridLayout(2, 1));
                pp2 = new JPanel();
                pp3 = new JPanel();
                pp2.add(cb);
                pp3.add(bb1);

                pp1.add(pp2);
                pp1.add(pp3);
                frame.add(pp1);
                frame.setDefaultCloseOperation(2);
                frame.setSize(450, 300);
                frame.setTitle("Escolha um vizinho pra te dar dinheiro");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

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
                JFrame frame = new JFrame();
                JPanel pp1, pp2, pp3;
                JButton bb1;
                JComboBox cb;

                Vector v = new Vector();
                for (int k = 0; k < control.listaJogadores().size(); k++) {
                    if (control.minhasInfomacoes().getLocalPort() != Integer.parseInt(((Jogadores) control.listaJogadores().get(k)).getPorta())) {
                        v.add(((Jogadores) control.listaJogadores().get(k)).getNick());
                    }
                }
                cb = new JComboBox(v);

                bb1 = new JButton("Confirmar");
                bb1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        try {
                            control.manda("DE@200", cb.getSelectedItem().toString());
                        } catch (IOException ex) {
                            Logger.getLogger(Cont2.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

                pp1 = new JPanel(new GridLayout(2, 1));
                pp2 = new JPanel();
                pp3 = new JPanel();
                pp2.add(cb);
                pp3.add(bb1);

                pp1.add(pp2);
                pp1.add(pp3);
                frame.add(pp1);
                frame.setDefaultCloseOperation(2);
                frame.setSize(450, 300);
                frame.setTitle("Escolha um vizinho e pague dinheiro");
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

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

    /**
     * Aqui o jogador pode escolher para qual casa deseja ir, ele tem opção de
     * ir para a casa achou comprador ou então compras entretenimento, e pode
     * realizar operações dependendo da casa escolhida.
     *
     * @param compraAux lista de cartas que o cliente possui.
     */
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
