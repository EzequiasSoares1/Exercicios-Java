package banco;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaBancaria conta;

    public Cliente(String cpf, ContaBancaria conta, String nome) {
        this.cpf = cpf;
        this.conta = conta;
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

    public ContaBancaria getConta() {
        return conta;
    }
    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

}
