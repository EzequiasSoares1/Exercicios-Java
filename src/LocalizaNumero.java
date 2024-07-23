import java.util.Scanner;

//Fa�a um programa para pesquisar o valor 8 no vetor dado:
//inteiro vetor[] = {1, 3, 5, 8, 9, 10}
public class LocalizaNumero {
    // Corrigir este algoritmo.
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] vetor = {1,2,3,4,5,6,7,8,9,10};

        System.out.print("Digite um numero: ");
        int numero = entrada.nextInt();
        int index = -1;

        for (int i=0 ; i < vetor.length; i++) {
            if (vetor[i] == numero){
                index = i;
                break;
            }
        }
        
        if (index != -1) {
            System.out.println("Achei");
            System.out.printf("Na Posi��o %d est� localizado do numero %d.", index, vetor[index]);
        }else {
            System.out.println("Nao foi localizado");
        }
    }
}