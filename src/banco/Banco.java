package banco;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Banco {
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();

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

            operacoesBancarias(clientes, operacao);
        }
    }

    public static void operacoesBancarias(ArrayList<Cliente> clientes, int operacao){
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
            exibirExtrato(cliente.getContaCorrente());
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
            status = transferirValor(cliente.getContaCorrente() , clientes.get(destino -1).getContaCorrente(), valor);

        }
        else if(operacao == 3){

            imprimirMensagem("Qual o valor que deseja depositar?");
            valor = pegarValor();
            status = cliente.getContaCorrente().deposito(valor);

        }
        else if(operacao == 4){
            imprimirMensagem("Qual o valor que deseja sacar?");
            valor = pegarValor();
            status = cliente.getContaCorrente().sacar(valor);
        }

        mostrarStatus(status);

    }

    public static void mostrarStatus(Boolean status){
        if (status)
            imprimirMensagem("transferido com sucesso");
        else
            imprimirMensagem("transferencia falhou");
    }

    public static void cadastrarCliente(ArrayList<Cliente> clientes){
        Random gerador = new Random();

        imprimirMensagem("Cadastro de Cliente");

        imprimirMensagem("Digite o nome completo do cliente");
        String nome = entrada.nextLine();
        imprimirMensagem("Digite o cpf do cliente");
        String cpf = entrada.nextLine();

        ContaCorrente contaCorrente = new ContaCorrente(gerador.nextInt(), 0);

        Cliente cliente = new Cliente(cpf,contaCorrente,nome);
        imprimirMensagem("Cliente Cadastrado com sucesso");

        clientes.add(cliente);

    }

    public static void listarClientes(ArrayList<Cliente> clientes){
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

    public static void exibirExtrato(ContaCorrente contaCorrente){
        System.out.println(contaCorrente.getExtrato());
    }

    public static boolean transferirValor(ContaCorrente proprietario, ContaCorrente destinatario, double valor){
        return proprietario.sacar(valor) ? destinatario.deposito(valor) :false;
    }
}
