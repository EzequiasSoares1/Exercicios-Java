package jogoDaVelha;

//1. Implementar o jogo em JAVA.
//2. Usar o scanner.

import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1, jogador2;

        imprimirMensagem("Jogador 1 digite seu nome: ");
        String nome = entrada.nextLine();
        imprimirMensagem("Você será o X");
        jogador1 = new Jogador(nome, "X");

        imprimirMensagem("Jogador 2 digite seu nome: ");
        String nome2 = entrada.nextLine();
        imprimirMensagem("Você será o O");
        jogador2 = new Jogador(nome2, "O");

        imprimirMensagem(jogador1 + "\n" + jogador2);
        imprimirTabuleiro(tabuleiro);

        Jogador jogadorAtual = jogador1;
        int jogadas = 0;

        while (true) {
            int linha, coluna;

            imprimirMensagem(jogadorAtual.getNome() + " escolha a linha que deseja jogar:");
            linha = entrada.nextInt();
            imprimirMensagem(jogadorAtual.getNome() + " escolha a coluna que deseja jogar:");
            coluna = entrada.nextInt();

            if (linha > 2 || coluna > 2) {
                imprimirMensagem("Ops, posição não existe");
                continue;
            } else if (tabuleiro.isOcupado(linha, coluna)) {
                imprimirMensagem("Ops, posição já ocupada!");
                continue;
            } else {
                tabuleiro.marcarTabuleiro(linha, coluna, jogadorAtual.getSimbolo());
                jogadas++;
            }

            imprimirTabuleiro(tabuleiro);

            String vencedor = tabuleiro.ganhou();
            if (!vencedor.equals("")) {
                String ganhador = vencedor.equals(jogador1.getSimbolo()) ? jogador1.getNome() : jogador2.getNome();
                imprimirMensagem(ganhador + ", você ganhou!!");
                break;
            } else if (jogadas == 9) {
                imprimirMensagem("Ihh, deu velha! Jogue novamente.");
                break;
            }

            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }
    }

    public static void imprimirMensagem(String mensagem){
        System.out.println(mensagem);
    }

    public static void imprimirTabuleiro(Tabuleiro tabuleiro) {
        System.out.print("\n\n 0   1    2\n\n");
        for (int posicao1 = 0; posicao1 < 3; posicao1++) {
            for (int posicao2 = 0; posicao2 < 3; posicao2++) {
                System.out.print(" " + tabuleiro.getLinhasEColunas()[posicao1][posicao2]);
                if (posicao2 < 2) {
                    System.out.print(" | ");
                }
                if (posicao2 == 2) {
                    System.out.print("  " + posicao1);
                }
            }
            if (posicao1 < 2) {
                System.out.print("\n------------");
            }
            System.out.println("\n");
        }
    }
}