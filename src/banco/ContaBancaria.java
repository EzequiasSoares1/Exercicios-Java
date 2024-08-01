package banco;

import banco.exception.DepositoInvalidoException;
import banco.exception.EstouroSaqueException;

import java.util.ArrayList;
import java.util.Date;

public abstract class ContaBancaria {
    private int numero;
    private double saldo;
    private Date date;
    private ArrayList<Double> transacoes;

    public ContaBancaria(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        this.date = new Date();
        this.transacoes = new ArrayList<>();
    }

    public boolean deposito(double valor) throws DepositoInvalidoException {
        if(valor > 0) {
            this.saldo += valor;
            this.transacoes.add(valor);
            return true;
        }
        throw new DepositoInvalidoException("Nao é permitido deposito de valores negativos");
    }

    public boolean sacar(double valor) throws EstouroSaqueException{
        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.transacoes.add(-valor);
            return true;
        }
        throw new EstouroSaqueException("Saldo insuficiente");
    }

    public abstract String getExtrato();

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

    public ArrayList<Double> getTransacoes() {
        return transacoes;
    }
    public void setTransacoes(ArrayList<Double> transacoes) {
        this.transacoes = transacoes;
    }

}
