package Sistema;

import java.util.Scanner;

public class Entrada {
//
    static Scanner scn = new Scanner(System.in);

    //Função para conseguirmos o valor de entrada inteiro do jogador de maneira que não ocorram erros caso o mesmo digite algo que não sejam números inteiros.
    public static int entradaInt(){
        try { // (Tratamento de excessões)
            int tmp = scn.nextInt();
            scn.nextLine();
            return tmp;
        } catch(Exception e){ // (Tratamento de excessões)
            System.out.println("Entrada Inválida");
            scn.nextLine();
            return -1;
        }
    }
    //Função para conseguirmos o valor de entrada de texto do jogador.
    public static String entradaStr(){
        return scn.next();
    }

}
