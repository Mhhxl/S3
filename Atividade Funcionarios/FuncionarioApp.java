import java.util.Scanner;

public class FuncionarioApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variáveis para guardar temporariamente os cadastros
        Professor professor = null;
        Tecnico tecnico = null;

        int opcao = -1;

        do {
            System.out.println("\n===== SISTEMA DE FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Técnico");
            System.out.println("3 - Exibir Professor");
            System.out.println("4 - Exibir Técnico");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de texto do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Professor: ");
                    String nomeProf = scanner.nextLine();
                    
                    System.out.print("Salário: ");
                    double salarioProf = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer
                    
                    System.out.print("Disciplina: ");
                    String disciplina = scanner.nextLine();

                    // Criando o objeto usando o construtor que fizemos!
                    professor = new Professor(nomeProf, salarioProf, disciplina);
                    System.out.println("Professor cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do Técnico: ");
                    String nomeTec = scanner.nextLine();
                    
                    System.out.print("Salário: ");
                    double salarioTec = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer
                    
                    System.out.print("Setor: ");
                    String setor = scanner.nextLine();

                    // Instanciando o Técnico com o construtor
                    tecnico = new Tecnico(nomeTec, salarioTec, setor);
                    System.out.println("Técnico cadastrado com sucesso!");
                    break;

                case 3:
                    if (professor != null) {
                        System.out.println("\n--- DADOS DO PROFESSOR ---");
                        professor.exibirDados();
                    } else {
                        System.out.println("Nenhum professor cadastrado ainda!");
                    }
                    break;

                case 4:
                    if (tecnico != null) {
                        System.out.println("\n--- DADOS DO TÉCNICO ---");
                        tecnico.exibirDados();
                    } else {
                        System.out.println("Nenhum técnico cadastrado ainda!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}