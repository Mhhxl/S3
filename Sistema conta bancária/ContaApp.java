import java.util.Scanner;

public class ContaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cadastroConta repositorio = new cadastroConta();
        boolean executar = true;

        while (executar) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Buscar Conta");
            System.out.println("3. Remover Conta");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarConta(scanner, repositorio);
                    break;
                case "2":
                    buscarConta(scanner, repositorio);
                    break;
                case "3":
                    removerConta(scanner, repositorio);
                    break;
                case "4":
                    executar = false;
                    System.out.println("Programa encerrado com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha um valor entre 1 e 4.");
            }
        }

        scanner.close();
    }

    private static void cadastrarConta(Scanner scanner, cadastroConta repositorio) {
        try {
            System.out.print("Informe o número da conta: ");
            String numero = scanner.nextLine();

            System.out.print("Informe o nome do titular: ");
            String titular = scanner.nextLine();

            System.out.print("Informe o saldo inicial: ");
            String saldoStr = scanner.nextLine();
            
            double saldo;
            try {
                saldo = Double.parseDouble(saldoStr);
            } catch (NumberFormatException e) {
                throw new ExcecaoDadoInvalido("Valor de saldo inválido! Digite um número válido.");
            }

            Conta conta = new Conta(numero, titular, saldo);
            repositorio.inserir(conta);
            System.out.println("Conta cadastrada com sucesso!");

        } catch (ExcecaoDadoInvalido | ExcecaoElementoJaExistente | ExcecaoRepositorio e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    private static void buscarConta(Scanner scanner, cadastroConta repositorio) {
        try {
            System.out.print("Informe o número da conta para busca: ");
            String numero = scanner.nextLine();

            Conta conta = repositorio.buscar(numero);
            System.out.println("\n--- DADOS DA CONTA ---");
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));

        } catch (ExcecaoElementoInexistente e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }
    }

    private static void removerConta(Scanner scanner, cadastroConta repositorio) {
        try {
            System.out.print("Informe o número da conta para remoção: ");
            String numero = scanner.nextLine();

            repositorio.remover(numero);
            System.out.println("Operação realizada com sucesso! Conta removida.");

        } catch (ExcecaoElementoInexistente e) {
            System.out.println("Erro na remoção: " + e.getMessage());
        }
    }
}