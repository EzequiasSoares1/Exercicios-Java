package banco.exception;

public class DepositoInvalidoException extends Exception{
    public DepositoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
