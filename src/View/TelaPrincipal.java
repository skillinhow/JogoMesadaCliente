/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Excecoes.SaldoRuimException;
import Model.ComprasEnt;
import Model.Correios;
import TesteCont.Cont;
import TesteCont.Cont2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author thelu
 */
public class TelaPrincipal extends JFrame {

    private JPanel principal, base, tabuleiro, menu, info, dado, players, blank;
    private JPanel start, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20;
    private JPanel c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, sorte;
    private JLabel saldo, divida, numDado, jogadores, j1, j2, j3, j4, j5, j6;
    private JButton emprestimo, lancarDado, correios, compras;
    private GridBagConstraints limit;
    private GridBagLayout layout;
    private Cont2 cont = new Cont2();
    private Cont contro = new Cont();
    private Stack<ComprasEnt> cartaEnt = new Stack();

    public TelaPrincipal() {
        super("Jogo da Mesada");

        principal = new JPanel(new BorderLayout());
        menu = new JPanel(new GridLayout(5, 1));
        blank = new JPanel();
        base = new JPanel(new BorderLayout());
        tabuleiro = new JPanel();
        saldo = new JLabel("Saldo");
        divida = new JLabel("Divida");
        numDado = new JLabel("Num Dado: ");
        jogadores = new JLabel("Jogadores");
        j1 = new JLabel("Alyson");
        j2 = new JLabel("Camille");
        j3 = new JLabel("Emanuel");
        j4 = new JLabel("Felipe");
        j5 = new JLabel("Lucas");
        j6 = new JLabel("Marcelo");
        emprestimo = new JButton("Emprestimo");
        lancarDado = new JButton("Lançar dado");
        correios = new JButton("Correios");
        compras = new JButton("Compras e Entreterimento");
        limit = new GridBagConstraints();
        layout = new GridBagLayout();

        tabuleiro.setLayout(layout);

        criaMenu();
        criaTabuleiro();

        principal.add(new JLabel(new ImageIcon("src/images/logo.png")), BorderLayout.NORTH);
        principal.add(menu, BorderLayout.WEST);
        principal.add(tabuleiro, BorderLayout.CENTER);

        base.add(principal, BorderLayout.CENTER);

        this.add(base);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setVisible(true);

    }

    private void criaMenu() {

        info = new JPanel(new GridLayout(3, 0));
        info.add(saldo);
        info.add(divida);
        info.add(emprestimo);

        dado = new JPanel(new GridLayout(2, 0));
        dado.add(numDado);
        dado.add(lancarDado, limit);

        players = new JPanel(new GridLayout(7, 0));
        players.add(jogadores);
        players.add(j1);
        players.add(j2);
        players.add(j3);
        players.add(j4);
        players.add(j5);
        players.add(j6);

        menu.add(blank);
        menu.add(info);
        menu.add(dado);
        menu.add(players);

    }

    private void criaTabuleiro() {

        //Start
        limit.gridx = 2;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        start = new JPanel();
        start.add(new JLabel(new ImageIcon("src/images/partida2.png")));
        start.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(start, limit);

        //Casa 1
        limit.gridx = 4;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c1 = new JPanel();
        c1.add(new JLabel(new ImageIcon("src/images/4.png")));
        c1.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c1, limit);

        //Casa 2
        limit.gridx = 6;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c2 = new JPanel();
        c2.add(new JLabel(new ImageIcon("src/images/premiio.png")));
        c2.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c2, limit);

        //Casa 3
        limit.gridx = 8;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c3 = new JPanel();
        c3.add(new JLabel(new ImageIcon("src/images/4.png")));
        c3.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c3, limit);

        //Casa 4
        limit.gridx = 10;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c4 = new JPanel();
        c4.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c4.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c4, limit);

        //Casa 5
        limit.gridx = 12;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c5 = new JPanel();
        c5.add(new JLabel(new ImageIcon("src/images/4.png")));
        c5.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c5, limit);

        //Casa 6
        limit.gridx = 14;
        limit.gridy = 1;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c6 = new JPanel();
        c6.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c6.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c6, limit);

        //Casa 7
        limit.gridx = 2;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c7 = new JPanel();
        c7.add(new JLabel(new ImageIcon("src/images/praia.png")));
        c7.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c7, limit);

        //Casa 8
        limit.gridx = 4;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c8 = new JPanel();
        c8.add(new JLabel(new ImageIcon("src/images/arrocha.png")));
        c8.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c8, limit);

        //Casa 9
        limit.gridx = 6;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c9 = new JPanel();
        c9.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c9.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c9, limit);

        //Casa 10
        limit.gridx = 8;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c10 = new JPanel();
        c10.add(new JLabel(new ImageIcon("src/images/niver.png")));
        c10.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c10, limit);

        //Casa 11
        limit.gridx = 10;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c11 = new JPanel();
        c11.add(new JLabel(new ImageIcon("src/images/4.png")));
        c11.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c11, limit);

        //Casa 12
        limit.gridx = 12;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c12 = new JPanel();
        c12.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c12.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c12, limit);

        //Casa 13
        limit.gridx = 14;
        limit.gridy = 3;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c13 = new JPanel();
        c13.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c13.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c13, limit);

        //Casa 14
        limit.gridx = 2;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c14 = new JPanel();
        c14.add(new JLabel(new ImageIcon("src/images/floresta.png")));
        c14.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c14, limit);

        //Casa 15
        limit.gridx = 4;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c15 = new JPanel();
        c15.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c15.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c15, limit);

        //Casa 16
        limit.gridx = 6;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c16 = new JPanel();
        c16.add(new JLabel(new ImageIcon("src/images/4.png")));
        c16.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c16, limit);

        //Casa 17
        limit.gridx = 8;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c17 = new JPanel();
        c17.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c17.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c17, limit);

        //Casa 18
        limit.gridx = 10;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c18 = new JPanel();
        c18.add(new JLabel(new ImageIcon("src/images/lanche.png")));
        c18.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c18, limit);

        //Casa 19
        limit.gridx = 12;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c19 = new JPanel();
        c19.add(new JLabel(new ImageIcon("src/images/4.png")));
        c19.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c19, limit);

        //Casa 20
        limit.gridx = 14;
        limit.gridy = 5;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c20 = new JPanel();
        c20.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c20.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c20, limit);

        //Casa 21
        limit.gridx = 2;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c21 = new JPanel();
        c21.add(new JLabel(new ImageIcon("src/images/negocio.png")));
        c21.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c21, limit);

        //Casa 22
        limit.gridx = 4;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c22 = new JPanel();
        c22.add(new JLabel(new ImageIcon("src/images/4.png")));
        c22.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c22, limit);

        //Casa 23
        limit.gridx = 6;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c23 = new JPanel();
        c23.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c23.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c23, limit);

        //Casa 24
        limit.gridx = 8;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c24 = new JPanel();
        c24.add(new JLabel(new ImageIcon("src/images/4.png")));
        c24.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c24, limit);

        //Casa 25
        limit.gridx = 10;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c25 = new JPanel();
        c25.add(new JLabel(new ImageIcon("src/images/compras.png")));
        c25.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c25, limit);

        //Casa 26
        limit.gridx = 12;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c26 = new JPanel();
        c26.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c26.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c26, limit);

        //Casa 27
        limit.gridx = 14;
        limit.gridy = 7;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c27 = new JPanel();
        c27.add(new JLabel(new ImageIcon("src/images/bolao.png")));
        c27.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c27, limit);

        //Casa 28
        limit.gridx = 2;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c28 = new JPanel();
        c28.add(new JLabel(new ImageIcon("src/images/shop.png")));
        c28.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c28, limit);

        //Casa 39
        limit.gridx = 4;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c29 = new JPanel();
        c29.add(new JLabel(new ImageIcon("src/images/comprador.png")));
        c29.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c29, limit);

        //Casa 30
        limit.gridx = 6;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c30 = new JPanel();
        c30.add(new JLabel(new ImageIcon("src/images/maratona.png")));
        c30.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c30, limit);

        //Casa 31
        limit.gridx = 8;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        c31 = new JPanel();
        c31.add(new JLabel(new ImageIcon("src/images/mesada.png")));
        c31.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(c31, limit);

        //Sorte Grande
        limit.gridx = 14;
        limit.gridy = 9;
        limit.gridheight = 2;
        limit.gridwidth = 1;
        limit.fill = GridBagConstraints.BOTH;
        sorte = new JPanel();
        sorte.add(new JLabel(new ImageIcon("src/images/sorte.png")));
        sorte.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        tabuleiro.add(sorte, limit);

        BotaoEmprestimo bt = new BotaoEmprestimo();

        emprestimo.addActionListener(bt);

        JogaDado joga = new JogaDado();
        lancarDado.addActionListener(joga);
        saldo.setText("Saldo: " + String.valueOf(cont.saldo()));
    }

    private class BotaoEmprestimo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int valor = (Integer.parseInt(JOptionPane.showInputDialog(null, "Digite "
                    + "o valor do emprestimo:(Apenas números)")));
            cont.emprestimo(valor);
            saldo.setText("Saldo: " + String.valueOf(cont.saldo()));
            divida.setText("Divida: " + String.valueOf(cont.retDivida()));

        }

    }

    private class JogaDado implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Random nDado = new Random();
            int saiu = nDado.nextInt(6) + 1;
            int casa = Integer.parseInt(cont.anda(saiu));
            System.out.println("Num: " + casa);
            if (casa < 31) {
                numDado.setText("Num Dado: " + saiu);
                contro.fazAcao(String.valueOf(casa));
            } else {
                contro.fazAcao("31");
            }
            //**contro.fazAcao("10");

        }

    }
    public void fazAcao(String numOpcao) throws SaldoRuimException {

        switch (numOpcao) {

            case "1":
            case "11":
            case "19":
            case "22":
                Stack<Correios> cor = cont.retiraCartaCorreio(1);
                cont.fazAcoesGeral(cor);

                break;

            case "5":
            case "24":
                Stack<Correios> cor2 = cont.retiraCartaCorreio(2);
                cont.fazAcoesGeral(cor2);
                break;

            case "3":
            case "16":
                Stack<Correios> cor3 = cont.retiraCartaCorreio(3);
                cont.fazAcoesGeral(cor3);
                break;
            case "2":
                //Faz a jogada de premio, ma nesse caso ta passando um jogador
                //ainda é necessário decidir se precisa passar a conta, ou se vai 
                //fazer isso lá no controller.
                cont.fazJogadaPremio(jog2);

                break;

            case "6":
            case "13":
            case "20":
            case "27":
                /**
                 * Pra receber essa quantidade de jogadores podemos fazer uma chamada 
                 * do método de comunicação, ver os parâmetros e testar.
                 */

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

                cont.fazJogadaBolao(qtdJog, true);

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
                 * nesse caso também é necessário passar uma conta, mas podemos 
                 * definir se passamos a conta, ou se a conta estará no controller.
                 * e também ao receber essa exceção já deve chamar o emprestimo
                 * no try catch.
                 */
                cont.fazJogadaDiversao(jog2);

                break;
            case "4":
            case "12":
            case "15":
            case "25":
                /**
                 * Compras e entretenimento.
                 * Nesse caso ta tendo retorno, é necessário saber se precisamos 
                 * desse retorno, ou se fazemos uma lista no proprio controller
                 * e então guardariamos essa carta lá.
                 */
                
                /**
                 * Ao retirar a carta devo perguntar ao jogador se quer ficar 
                 * com a carta, se sim, verifico o saldo. E efetuo a venda.
                 */
                
                cont.retiraCartaEnt();
                
                break;
                
            case "9":
            case "17":
            case "23":
            case "26":
            case "29":
                /**
                 * Achou comprador.
                 * esse numOpção é o tipo de carta que o cliente escolheu na janela
                 * se escolher 1 é uma casa, 2 é uma moto, 3 iate e 4 carro;
                 * esse null é a conta, e mais uma vez falta decidir se passa a conta,
                 * ou se a conta estará no controller.
                 */
                
                cont.fazJogadaEnt(numOpcao, null);
                break;

            case "8":
                //Concurso de Banda de Arrocha.
                /**
                 * Esse numero que está sendo passado é numero do dado, além disso 
                 * precisamos criar uma variável que indique se é a vez do jogador.
                 */
                int numDado = 0;
                cont.fazJogadaArrocha(numDado);
                break;
            case "10":
                //Feliz aniversário.                
                
                break;
            case "21":
                //Negócio de ocasião.               
               

                break;
            case "30":
                //Maratona.
                /**
                 * Lembrando que quem ta na casa não joga, apenas os outros, esse
                 * numdado vai ser o multiplicador pra saber quanto o cara vai ganhar.
                 * 
                 */
                cont.fazJogadaMaratona(numDado);
                break;
            case "31":
                /**
                 * Dia de Mesada, retira um valor de 3500.
                 */
                break;

        }
    }

//    public static void main(String[] args) {
//        TelaPrincipal x = new TelaPrincipal();
//    }
}
