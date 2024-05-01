import java.util.Scanner;

class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;
    
    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0.0;
    }
    
    public void consultarSaldo() {
        System.out.println("Seu saldo atual é R$" + saldo);
    }
    
    public void depositar (double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$" + valor + " realizado com sucesso");
        } else {
            System.out.println("valor inválido");
           
        }
    }
    
    public void sacar(double valor) {
        if (valor >0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo inbrenosuficiente ou valor incorreto");
        }
    }
    
}





public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu nome por favor");
        String nome = sc.nextLine();
        System.out.println("Infomre seu sobrenome, por favor");
        String sobrenome = sc.nextLine();
        System.out.println("Informe seu cpf, por favor");
        String cpf = sc.nextLine();
        
        Cliente cliente = new Cliente(nome, sobrenome, cpf);
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nO que você deseja?");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Realizar depósito");
            System.out.println("3 - Realizar saque");
            System.out.println("4 - Encerrar acesso");
            
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                case 2:
                    System.out.println( "Informe o valor a ser depositado:");
                            double valorDeposito = sc.nextDouble();
                            cliente.depositar(valorDeposito);
                            break;
                case 3:
                    System.out.println("Informe o valor a ser sacado:");
                    double valorSaque = sc.nextDouble();
                    cliente.sacar(valorSaque);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Obrigado pela preferência, encerrando acesso.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}   