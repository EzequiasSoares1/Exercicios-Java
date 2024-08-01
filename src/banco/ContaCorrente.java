package banco;

public class ContaCorrente extends ContaBancaria{

    public ContaCorrente(int numero, double saldo) {
        super(numero, saldo);
    }

    @Override
    public String getExtrato(){
        return "numero: " + getNumero() + ", saldo: " + getSaldo() + ", transacoes: " + getTransacoes();
    }

}
