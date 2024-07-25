package xadrez;

import javax.swing.*;
import java.util.Scanner;

public class ChessBoard {
    public static void main(String[] args) {
        String[][] board = {
                {"R", "N", "B", "Q", "K", "B", "N", "R"},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {"r", "n", "b", "q", "k", "b", "n", "r"}
        };

        Scanner entrada = new Scanner(System.in);

        while (true) {
            imprimirBoard(board);
            int coluna;

            String res = capturarTeclado("Jogador 1 (Peão Branco), escolha a coluna do peão que deseja mover:");

            if (eNumerico(res)) {
                coluna = Integer.parseInt(res);
            } else {
                imprimirMensagem("valor invalido");
                continue;
            }


            if(coluna < 0 || coluna > 7) {
                imprimirMensagem("posicao invalida");
                continue;
            }

            moverPeao(board, coluna, true);

            imprimirBoard(board);

            res = capturarTeclado("Jogador 2 (Peão Preto), escolha a coluna do peão que deseja mover:");

            if (eNumerico(res)) {
                coluna = Integer.parseInt(res);
            } else {
                imprimirMensagem("valor invalido");
                continue;
            }

            if(coluna < 0 || coluna > 7) {
                imprimirMensagem("posicao invalida");
                continue;
            }

            moverPeao(board, coluna, false);
            imprimirBoard(board);
        }
    }

    public static boolean eNumerico(String str) {
        return str.matches("[0-9]*");
    }

    public static void moverPeao(String[][] board, int coluna, boolean isBranco) {
        if (isBranco) {
            for (int i = 0; i < board.length - 1; i++) {
                if (board[i][coluna].equals("P") && (board[i + 1][coluna].equals(" ") || board[i + 1][coluna].equals("p"))) {
                    board[i][coluna] = " ";
                    if (i < board.length - 1) {
                        board[i + 1][coluna] = "P";
                    }
                    break;
                }
            }
        } else {
            for (int i = board.length - 1; i > 0; i--) {
                if (board[i][coluna].equals("p") && (board[i - 1][coluna].equals(" ") || board[i - 1][coluna].equals("P"))) {
                    board[i][coluna] = " ";
                    if (i > 0) {
                        board[i - 1][coluna] = "p";
                    }
                    break;
                }
            }
        }
    }

    public static void imprimirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static String capturarTeclado(String texto){
        return JOptionPane.showInputDialog(texto);
    }
    public static void imprimirBoard(String[][] board) {
      String tab = "\n 0 1 2 3 4 5 6 7\n";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                tab += board[i][j] + " ";
            }
            tab += "  \n";
        }

        imprimirMensagem(tab);
    }
}
