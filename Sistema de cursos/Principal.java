import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Curso curso = null;
        String nomeAluno = "";
        double valorMatriculaPaga = 0.0;
        boolean matriculado = false;

        while (true) {
            System.out.println("\n--- SISTEMA DE CURSOS E MATRÍCULAS ---");
            System.out.println("1. Cadastrar curso");
            System.out.println("2. Escolher curso presencial ou online");
            System.out.println("3. Cadastrar nome do aluno");
            System.out.println("4. Realizar matrícula");
            System.out.println("5. Realizar matrícula com desconto");
            System.out.println("6. Mostrar dados do curso");
            System.out.println("7. Mostrar dados da matrícula");
            System.out.println("8. Encerrar o programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Informe o código do curso: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Informe o nome do curso: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe a carga horária (horas): ");
                    int cargaHoraria = scanner.nextInt();
                    System.out.print("Informe o valor do curso: R$ ");
                    double valor = scanner.nextDouble();

                    System.out.println("\nTipo de Curso:");
                    System.out.println("1 - Presencial");
                    System.out.println("2 - Online");
                    System.out.print("Escolha o tipo: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    if (tipo == 1) {
                        System.out.print("Informe a sala: ");
                        String sala = scanner.nextLine();
                        System.out.print("Informe o turno: ");
                        String turno = scanner.nextLine();
                        curso = new CursoPresencial(codigo, nome, cargaHoraria, valor, sala, turno);
                        System.out.println("Curso Presencial cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("Informe o endereço da plataforma: ");
                        String plataforma = scanner.nextLine();
                        System.out.print("Informe o código de acesso: ");
                        String codigoAcesso = scanner.nextLine();
                        curso = new CursoOnline(codigo, nome, cargaHoraria, valor, plataforma, codigoAcesso);
                        System.out.println("Curso Online cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido. Curso não cadastrado.");
                    }
                    break;

                case 2:
                    if (curso == null) {
                        System.out.println("Nenhum curso cadastrado no momento.");
                    } else {
                        System.out.println("O curso cadastrado é do tipo: " + curso.getClass().getSimpleName());
                    }
                    break;

                case 3:
                    System.out.print("Informe o nome do aluno: ");
                    nomeAluno = scanner.nextLine();
                    System.out.println("Aluno " + nomeAluno + " registado com sucesso!");
                    break;

                case 4:
                    if (curso != null && !nomeAluno.isEmpty()) {
                        valorMatriculaPaga = curso.realizarMatricula();
                        matriculado = true;
                        System.out.println("Matrícula realizada com sucesso para o aluno " + nomeAluno + "!");
                        System.out.println("Valor a pagar: R$ " + String.format("%.2f", valorMatriculaPaga));
                    } else {
                        System.out.println("Certifique-se de cadastrar o curso e o nome do aluno primeiro.");
                    }
                    break;

                case 5:
                    if (curso != null && !nomeAluno.isEmpty()) {
                        System.out.print("Informe o percentual de desconto (%): ");
                        double desconto = scanner.nextDouble();
                        valorMatriculaPaga = curso.realizarMatricula(desconto);
                        matriculado = true;
                        System.out.println("Matrícula com desconto realizada com sucesso para " + nomeAluno + "!");
                        System.out.println("Valor com desconto: R$ " + String.format("%.2f", valorMatriculaPaga));
                    } else {
                        System.out.println("Certifique-se de cadastrar o curso e o nome do aluno primeiro.");
                    }
                    break;

                case 6:
                    if (curso != null) {
                        System.out.println("\n--- DADOS DO CURSO ---");
                        curso.exibirDados();
                    } else {
                        System.out.println("Nenhum curso cadastrado!");
                    }
                    break;

                case 7:
                    if (matriculado) {
                        System.out.println("\n--- DADOS DA MATRÍCULA ---");
                        System.out.println("Aluno: " + nomeAluno);
                        System.out.println("Curso: " + curso.getNome());
                        System.out.println("Valor Pago: R$ " + String.format("%.2f", valorMatriculaPaga));
                    } else {
                        System.out.println("Nenhuma matrícula realizada até ao momento.");
                    }
                    break;

                case 8:
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