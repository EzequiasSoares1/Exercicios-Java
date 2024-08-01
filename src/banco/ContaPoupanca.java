package banco;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContaPoupanca extends ContaBancaria{

    private float juros;
    private LocalDate dataPagamentoJuros;

    public ContaPoupanca(int numero, double saldo) {
        super(numero, saldo);
        dataPagamentoJuros = LocalDate.of(2024, 1, 1);;
    }

    @Override
    public String getExtrato() {
        return "numero: " + getNumero() + ", saldo: " + getSaldo() + ", transacoes: " + getTransacoes() + ", taxa de juros: " + juros;
    }

    public void aplicarJuros(double taxa) {
        LocalDate hoje = LocalDate.now();
        long mesesEntre = ChronoUnit.MONTHS.between(dataPagamentoJuros, hoje);
        if(getSaldo() != 0) {
            for (int i = 1; i < mesesEntre; i++) {
                double jurosAdd = getSaldo() * taxa;
                getTransacoes().add(jurosAdd);
                setSaldo(
                        jurosAdd + getSaldo()
                );
            }
        }
        dataPagamentoJuros = hoje;
    }
}
