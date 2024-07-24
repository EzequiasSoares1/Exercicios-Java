package jogoDaVelha;

public class Tabuleiro {

    private String[][] linhasEColunas;

    public Tabuleiro() {
        this.linhasEColunas = new String[][]{
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };
    }
    
    public boolean isOcupado(int linha, int coluna){
        return linhasEColunas[coluna][linha].equals(" ") ? false : true;
    }

    public void marcarTabuleiro(int linha, int coluna, String simbolo) {
        linhasEColunas[coluna][linha] = simbolo;
    }

    public String ganhou(){
        // Verificar linhas
        for(int i = 0; i < 3; i++) {
            if(!linhasEColunas[i][0].equals(" ") &&
                    linhasEColunas[i][0].equals(linhasEColunas[i][1]) &&
                    linhasEColunas[i][0].equals(linhasEColunas[i][2])) {
                return linhasEColunas[i][0];
            }
        }

        // Verificar colunas
        for(int j = 0; j < 3; j++) {
            if(!linhasEColunas[0][j].equals(" ") &&
                    linhasEColunas[0][j].equals(linhasEColunas[1][j]) &&
                    linhasEColunas[0][j].equals(linhasEColunas[2][j])) {
                return linhasEColunas[0][j];
            }
        }

        // Verificar diagonais
        if(!linhasEColunas[0][0].equals(" ") &&
                linhasEColunas[0][0].equals(linhasEColunas[1][1]) &&
                linhasEColunas[0][0].equals(linhasEColunas[2][2])) {
            return linhasEColunas[0][0];
        }

        if(!linhasEColunas[0][2].equals(" ") &&
                linhasEColunas[0][2].equals(linhasEColunas[1][1]) &&
                linhasEColunas[0][2].equals(linhasEColunas[2][0])) {
            return linhasEColunas[0][2];
        }

        // Nenhum vencedor
        return "";
    }

    public String[][] getLinhasEColunas() {
        return linhasEColunas;
    }
}
