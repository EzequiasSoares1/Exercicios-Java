package banco;
import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {
    private int numero;
    private double saldo;
    private Date date;
    private ArrayList<Double> transacoes;

    public boolean deposito(double valor) {
        if(valor > 0) {
            this.saldo += valor;
            this.transacoes.add(valor);
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.transacoes.add(-valor);
            return true;
        }
        return false;
    }

    public String getExtrato(){
        return "numero: " + this.numero + ", saldo: " + this.saldo + ", transacoes: " + this.transacoes;
    }

    public ContaCorrente(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.date = new Date();
        this.transacoes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
