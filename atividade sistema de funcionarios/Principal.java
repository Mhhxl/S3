import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = null;

        while (true) {
            System.out.println("\n===== MENU - SISTEMA DE FUNCIONÁRIOS =====");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Consultar / Mostrar Dados do Funcionário");
            System.out.println("3. Calcular Pagamento");
            System.out.println("4. Calcular Pagamento com Bónus");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n-- Cadastrar Funcionário --");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Selecione o tipo:");
                    System.out.println("1 - CLT");
                    System.out.println("2 - Freelancer");
                    System.out.print("Opção: ");
                    int tipo = scanner.nextInt();

                    if (tipo == 1) {
                        System.out.print("Informe o Salário Mensal: R$ ");
                        double salario = scanner.nextDouble();
                        funcionario = new FuncionarioCLT(nome, cpf, salario);
                        System.out.println("Funcionário CLT cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("Horas Trabalhadas: ");
                        int horas = scanner.nextInt();
                        System.out.print("Valor por Hora: R$ ");
                        double valorHora = scanner.nextDouble();
                        funcionario = new FuncionarioFreelancer(nome, cpf, horas, valorHora);
                        System.out.println("Funcionário Freelancer cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido. Cadastro cancelado.");
                    }
                    break;

                case 2:
                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado!");
                    } else {
                        funcionario.exibirDados();
                    }
                    break;

                case 3:
                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado!");
                    } else {
                        System.out.printf("Pagamento total: R$ %.2f\n", funcionario.calcularPagamento());
                    }
                    break;

                case 4:
                    if (funcionario == null) {
                        System.out.println("Nenhum funcionário cadastrado!");
                    } else {
                        System.out.print("Informe o valor do Bónus: R$ ");
                        double bonus = scanner.nextDouble();
                        System.out.printf("Pagamento com Bónus: R$ %.2f\n", funcionario.calcularPagamento(bonus));
                    }
                    break;

                case 5:
                    System.out.println("A encerrar o programa... Até logo!");
                    scanner.close();
                    return; // Sai da função main e encerra a execução

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}