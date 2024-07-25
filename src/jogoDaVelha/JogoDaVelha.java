package jogoDaVelha;
import javax.swing.JOptionPane;

public class JogoDaVelha {

    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1, jogador2;

        String nome = capturarTeclado("Jogador 1 digite seu nome: ");
        imprimirMensagem("Você será o X");
        jogador1 = new Jogador(nome, "X");

        String nome2 = capturarTeclado("Jogador 2 digite seu nome: ");
        imprimirMensagem("Você será o O");
        jogador2 = new Jogador(nome2, "O");

        imprimirMensagem(jogador1 + "\n" + jogador2);
        imprimirTabuleiro(tabuleiro);

        Jogador jogadorAtual = jogador1;
        int jogadas = 0;

        while (true) {
            int linha, coluna;
            String captura;

            captura = capturarTeclado(jogadorAtual.getNome() + " escolha a linha que deseja jogar:");
            if (eNumerico(captura)) {
                linha = Integer.parseInt(captura);
            }else {
                imprimirMensagem("valor invalido");
                return;
            }

            captura = capturarTeclado(jogadorAtual.getNome() + " escolha a coluna que deseja jogar:");

            if (eNumerico(captura)) {
                coluna = Integer.parseInt(captura);
            }else {
                imprimirMensagem("valor invalido");
                return;
            }


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

    public static boolean eNumerico(String str) {
        return str.matches("[0-9]*");
    }
    public static void imprimirMensagem(String mensagem){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static String capturarTeclado(String texto){
        return JOptionPane.showInputDialog(texto);
    }

    public static void imprimirTabuleiro(Tabuleiro tabuleiro) {

        String tab ="Tabuleiro:  \n\n 0   1    2\n\n";
        for (int posicao1 = 0; posicao1 < 3; posicao1++) {
            for (int posicao2 = 0; posicao2 < 3; posicao2++) {
               tab += " " + tabuleiro.getLinhasEColunas()[posicao1][posicao2];
                if (posicao2 < 2) {
                    tab += " | ";
                }
                if (posicao2 == 2) {
                    tab +="  " + posicao1;
                }
            }
            if (posicao1 < 2) {
                tab +="\n-------";
            }
            tab +="\n";
        }
        imprimirMensagem(tab);
    }
}