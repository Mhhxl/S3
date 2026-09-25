import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = null;
        int quantidade = 0;

        while (true) {
            System.out.println("\n--- SISTEMA DE VENDAS DE PRODUTOS ---");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Escolher produto físico ou digital");
            System.out.println("3. Mostrar dados do produto");
            System.out.println("4. Informar quantidade");
            System.out.println("5. Realizar venda");
            System.out.println("6. Realizar venda com desconto");
            System.out.println("7. Mostrar valor final");
            System.out.println("8. Encerrar o programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o código do produto: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Informe o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o preço unitário: R$ ");
                    double preco = scanner.nextDouble();

                    System.out.println("\nTipo de Produto:");
                    System.out.println("1 - Produto Físico");
                    System.out.println("2 - Produto Digital");
                    System.out.print("Escolha o tipo: ");
                    int tipo = scanner.nextInt();

                    if (tipo == 1) {
                        System.out.print("Informe o valor do frete: R$ ");
                        double frete = scanner.nextDouble();
                        produto = new ProdutoFisico(codigo, nome, preco, frete);
                        System.out.println("Produto Físico cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        produto = new ProdutoDigital(codigo, nome, preco);
                        System.out.println("Produto Digital cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido. Produto não cadastrado.");
                    }
                    break;

                case 2:
                    if (produto == null) {
                        System.out.println("Nenhum produto cadastrado até ao momento.");
                    } else {
                        System.out.println("O produto cadastrado atualmente é: " + produto.getClass().getSimpleName());
                    }
                    break;

                case 3:
                    if (produto != null) {
                        System.out.println("\n--- DADOS DO PRODUTO ---");
                        produto.exibirDados();
                    } else {
                        System.out.println("Nenhum produto cadastrado!");
                    }
                    break;

                case 4:
                    System.out.print("Informe a quantidade desejada: ");
                    quantidade = scanner.nextInt();
                    System.out.println("Quantidade registada: " + quantidade);
                    break;

                case 5:
                    if (produto != null && quantidade > 0) {
                        double total = produto.realizarVenda(quantidade);
                        System.out.println("Venda realizada com sucesso!");
                        System.out.println("Valor total (" + quantidade + " un): R$ " + String.format("%.2f", total));
                    } else {
                        System.out.println("Certifique-se de que cadastrou o produto e informou uma quantidade válida (> 0).");
                    }
                    break;

                case 6:
                    if (produto != null && quantidade > 0) {
                        System.out.print("Informe a percentagem de desconto (%): ");
                        double desconto = scanner.nextDouble();
                        double totalComDesconto = produto.realizarVenda(quantidade, desconto);
                        System.out.println("Venda com desconto realizada com sucesso!");
                        System.out.println("Valor total com " + desconto + "% de desconto: R$ " + String.format("%.2f", totalComDesconto));
                    } else {
                        System.out.println("Certifique-se de que cadastrou o produto e informou uma quantidade válida (> 0).");
                    }
                    break;

                case 7:
                    if (produto != null && quantidade > 0) {
                        double valorFinal = produto.realizarVenda(quantidade);
                        System.out.println("\n--- RESUMO DO VALOR FINAL ---");
                        System.out.println("Produto: " + produto.getNome());
                        System.out.println("Quantidade: " + quantidade);
                        System.out.println("Valor Final (sem descontos adicionais): R$ " + String.format("%.2f", valorFinal));
                    } else {
                        System.out.println("Não é possível calcular o valor final. Verifique se o produto e a quantidade foram informados.");
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