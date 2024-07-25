package banco;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaCorrente contaCorrente;

    public Cliente(String cpf, ContaCorrente contaCorrente, String nome) {
        this.cpf = cpf;
        this.contaCorrente = contaCorrente;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }
    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

}
