package banco;

import banco.exception.DepositoInvalidoException;
import banco.exception.EstouroSaqueException;

import java.util.*;

public class Banco {
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        while (true){
            cadastrarCliente(clientes);

            imprimirMensagem("Deseja cadastrar mais cleintes \n 1 - SIM \n 2 - NAO");
            String opcao = entrada.nextLine();

            if(opcao.equals("2")){
                break;
            }
            else if(!opcao.equals("1")){
                mensagemErro();
            }

        }

        while(true){
            imprimirMensagem("Gerenciar contas \n 1 - Imprimir extrato \n 2 - Transferir \n 3 - Depositar \n 4 - Sacar \n 5 - Sair");
            int operacao = entrada.nextInt();

            if(operacao == 5){
                imprimirMensagem("Tchau tchau");
                break;
            }

            try {
                operacoesBancarias(clientes, operacao);
            } catch (EstouroSaqueException | DepositoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void operacoesBancarias(List<Cliente> clientes, int operacao) throws EstouroSaqueException, DepositoInvalidoException {
        listarClientes(clientes);
        imprimirMensagem("selecione o numero do cliente");

        int numeroCliente = entrada.nextInt();

        if(numeroCliente < 1 || numeroCliente > clientes.size()){
            mensagemErro();
            return;
        }

        Cliente cliente = clientes.get(numeroCliente -1);
        double valor;
        boolean status = false;

        if (operacao == 1){
            exibirExtrato(cliente.getConta());
            return;
        }
        else if (operacao == 2){
            imprimirMensagem("Escolha o pra quem transferir:");
            int destino = entrada.nextInt();

            if(destino < 1 || destino > clientes.size()){
                mensagemErro();
                return;
            }

            imprimirMensagem("Qual o valor que deseja transferir?");
            valor = pegarValor();
            status = transferirValor(cliente.getConta() , clientes.get(destino -1).getConta(), valor);

        }
        else if(operacao == 3){

            imprimirMensagem("Qual o valor que deseja depositar?");
            valor = pegarValor();
            status = cliente.getConta().deposito(valor);

        }
        else if(operacao == 4){
            imprimirMensagem("Qual o valor que deseja sacar?");
            valor = pegarValor();
            status = cliente.getConta().sacar(valor);
        }

        mostrarStatus(status);

    }

    public static void mostrarStatus(boolean status){
        if (status)
            imprimirMensagem("transferido com sucesso");
        else
            imprimirMensagem("transferencia falhou");
    }

    public static void cadastrarCliente(List<Cliente> clientes){
        imprimirMensagem("Cadastro de Cliente");

        imprimirMensagem("Digite o nome completo do cliente");
        String nome = entrada.nextLine();
        imprimirMensagem("Digite o cpf do cliente");
        String cpf = entrada.nextLine();

        imprimirMensagem("Escolha o tipo de conta: \n 1 - Conta Corrente \n 2 - Conta Poupanca");
        String tipoConta = entrada.nextLine();

        if(tipoConta.equals("1")|| tipoConta.equals("2")){
            Cliente cliente = new Cliente(cpf,criarContaBancaria(tipoConta),nome);
            imprimirMensagem("Cliente Cadastrado com sucesso");

            clientes.add(cliente);
        }else {
            mensagemErro();
        }
    }

    public static ContaBancaria criarContaBancaria(String option){
        Random r = new Random();
        int numConta = r.nextInt(Integer.MAX_VALUE);

        return option.equals("1") ?
                new ContaCorrente(numConta,0) :
                new ContaPoupanca(numConta,0);
    }

    public static void listarClientes(List<Cliente> clientes){
        for (int i = 0; i < clientes.size(); i++){
            imprimirMensagem((i+1)+ " - " + clientes.get(i).getNome());
        }
    }

    public static void imprimirMensagem(String mensagem){
        System.out.println(mensagem);
    }

    public static void mensagemErro(){
        System.out.println("Opcao invalida");
    }

    public static double pegarValor(){
        return entrada.nextDouble();
    }

    public static void exibirExtrato(ContaBancaria conta){
        System.out.println(conta.getExtrato());
    }

    public static boolean transferirValor(ContaBancaria proprietario, ContaBancaria destinatario, double valor)
            throws EstouroSaqueException, DepositoInvalidoException {
        return (proprietario.sacar(valor) && destinatario.deposito(valor));
    }
}
