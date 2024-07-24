package jogoDaVelha;

public class Jogador {

    public Jogador(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    private String nome;
    private String simbolo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSimbolo() {
        return simbolo;
    }
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "nome: " + nome + " |" +" simbolo: " + simbolo;
    }
}
