import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("        CADASTRO INICIAL          ");
        System.out.println("=====================================");

        System.out.print("Número da agência: ");
        String numAgencia = scanner.nextLine();

        System.out.print("Nome da agência: ");
        String nomeAgencia = scanner.nextLine();

        System.out.print("Número da conta: ");
        String numConta = scanner.nextLine();

        System.out.print("Nome do titular: ");
        String titular = scanner.nextLine();

        System.out.print("Saldo inicial: R$ ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        // Criação dos objetos
        Agencia agencia = new Agencia(numAgencia, nomeAgencia);
        ContaCorrente conta = new ContaCorrente(numConta, titular, saldoInicial, agencia);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=====================================");
            System.out.println("               MENU                  ");
            System.out.println("=====================================");
            System.out.println("1 - Mostrar dados da conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Pagar com PIX");
            System.out.println("5 - Pagar com cartão");
            System.out.println("6 - Pagar em dinheiro");
            System.out.println("7 - Transferir (Desafio)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    conta.mostrarDados();
                    break;

                case 2:
                    conta.consultarSaldo();
                    break;

                case 3:
                    System.out.print("Informe o valor do depósito: R$ ");
                    double valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    conta.depositar(valorDeposito);
                    break;

                case 4:
                    System.out.print("Informe o valor do pagamento: R$ ");
                    double valorPix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Informe a chave PIX: ");
                    String chavePix = scanner.nextLine();
                    conta.pagar(valorPix, chavePix);
                    break;

                case 5:
                    System.out.print("Informe o valor do pagamento: R$ ");
                    double valorCartao = scanner.nextDouble();
                    System.out.print("Informe a quantidade de parcelas: ");
                    int parcelas = scanner.nextInt();
                    scanner.nextLine();
                    conta.pagar(valorCartao, parcelas);
                    break;

                case 6:
                    System.out.print("Informe o valor do pagamento: R$ ");
                    double valorDinheiro = scanner.nextDouble();
                    scanner.nextLine();
                    conta.pagar(valorDinheiro);
                    break;

                case 7:
                    System.out.print("Informe o número da conta de destino: ");
                    String contaDestino = scanner.nextLine();
                    System.out.print("Informe o valor da transferência: R$ ");
                    double valorTransf = scanner.nextDouble();
                    scanner.nextLine();
                    conta.transferir(valorTransf, contaDestino);
                    break;

                case 0:
                    System.out.println("A encerrar o sistema... Obrigado por utilizar os nossos serviços!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}