import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veiculo veiculo = null;
        int dias = 0;

        while (true) {
            System.out.println("\n--- SISTEMA DE LOCAÇÃO DE VEÍCULOS ---");
            System.out.println("1. Cadastrar um veículo");
            System.out.println("2. Escolher entre carro ou moto");
            System.out.println("3. Mostrar os dados do veículo");
            System.out.println("4. Informar a quantidade de dias");
            System.out.println("5. Calcular o valor do aluguel");
            System.out.println("6. Calcular o aluguel com desconto");
            System.out.println("7. Encerrar o programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Informe a placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Informe o modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Informe o ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Informe o valor da diária: R$ ");
                    double valorDiaria = scanner.nextDouble();

                    System.out.println("\nTipo de Veículo:");
                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.print("Escolha o tipo: ");
                    int tipo = scanner.nextInt();

                    if (tipo == 1) {
                        veiculo = new Carro(placa, modelo, ano, valorDiaria);
                        System.out.println("Carro cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        veiculo = new Moto(placa, modelo, ano, valorDiaria);
                        System.out.println("Moto cadastrada com sucesso!");
                    } else {
                        System.out.println("Tipo inválido. Veículo não cadastrado.");
                    }
                    break;

                case 2:
                    if (veiculo == null) {
                        System.out.println("Nenhum veículo cadastrado no momento.");
                    } else {
                        System.out.println("O veículo cadastrado atualmente é um(a): " + veiculo.getClass().getSimpleName());
                    }
                    break;

                case 3:
                    if (veiculo != null) {
                        System.out.println("\n--- DADOS DO VEÍCULO ---");
                        veiculo.exibirDados();
                    } else {
                        System.out.println("Nenhum veículo cadastrado!");
                    }
                    break;

                case 4:
                    System.out.print("Informe a quantidade de dias para a locação: ");
                    dias = scanner.nextInt();
                    System.out.println("Quantidade de dias gravada: " + dias);
                    break;

                case 5:
                    if (veiculo != null && dias > 0) {
                        double total = veiculo.calcularAluguel(dias);
                        System.out.println("Valor total do aluguel (" + dias + " dias): R$ " + String.format("%.2f", total));
                    } else {
                        System.out.println("Certifique-se de ter cadastrado o veículo e informado os dias (> 0).");
                    }
                    break;

                case 6:
                    if (veiculo != null && dias > 0) {
                        System.out.print("Informe o valor do desconto: R$ ");
                        double desconto = scanner.nextDouble();
                        double totalComDesconto = veiculo.calcularAluguel(dias, desconto);
                        System.out.println("Valor do aluguel com desconto: R$ " + String.format("%.2f", totalComDesconto));
                    } else {
                        System.out.println("Certifique-se de ter cadastrado o veículo e informado os dias (> 0).");
                    }
                    break;

                case 7:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}