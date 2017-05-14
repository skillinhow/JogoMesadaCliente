/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteCont;

import Excecoes.SaldoRuimException;
import java.util.Scanner;

/**
 *
 * @author Emanuel Santana
 */
public class testCont {

    private static String op;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Cont c = new Cont();
        

        while (true) {
            System.out.println("Digite uma opção 1 ou 5");
            op = s.nextLine();

            c.fazAcao(op);
        }

    }

}
