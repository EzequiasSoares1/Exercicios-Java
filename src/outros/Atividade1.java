package outros;

import java.util.Scanner;

public class Atividade1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int classeA = 50;
        int classeB = 30;
        int classeC = 20;

        System.out.print("Quantos bilhete de classe A foram vendidos: ");
        int qtdA = entrada.nextInt() * classeA;
        System.out.print("Quantos bilhete de classe B foram vendidos: ");
        int qtdB = entrada.nextInt() * classeB;
        System.out.print("Quantos bilhete de classe C foram vendidos: ");
        int qtdC= entrada.nextInt() * classeC;

        System.out.printf("foram vendidos %d da classe A, %d da classe B e %d da classe C.", qtdA , qtdB, qtdC);
    }
}
