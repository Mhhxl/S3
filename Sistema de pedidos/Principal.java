import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = null;

        while (true) {
            System.out.println("\n--- SISTEMA DE PEDIDOS ---");
            System.out.println("1. Cadastrar pedido");
            System.out.println("2. Escolher pedido local ou delivery");
            System.out.println("3. Mostrar dados do pedido");
            System.out.println("4. Escolher forma de pagamento");
            System.out.println("5. Pagar em dinheiro");
            System.out.println("6. Pagar via PIX");
            System.out.println("7. Pagar com cartão");
            System.out.println("8. Encerrar o programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Informe o número do pedido: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Informe o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o valor do pedido: R$ ");
                    double valor = scanner.nextDouble();

                    System.out.println("\nTipo de Pedido:");
                    System.out.println("1 - Local");
                    System.out.println("2 - Delivery");
                    System.out.print("Escolha o tipo: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    if (tipo == 1) {
                        pedido = new PedidoLocal(numero, nome, valor);
                        System.out.println("Pedido Local cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        System.out.print("Informe o endereço de entrega: ");
                        String endereco = scanner.nextLine();
                        System.out.print("Informe a taxa de entrega: R$ ");
                        double taxa = scanner.nextDouble();
                        pedido = new PedidoDelivery(numero, nome, valor, endereco, taxa);
                        System.out.println("Pedido Delivery cadastrado com sucesso!");
                    } else {
                        System.out.println("Tipo inválido. Pedido não cadastrado.");
                    }
                    break;

                case 2:
                    if (pedido == null) {
                        System.out.println("Nenhum pedido cadastrado no momento.");
                    } else {
                        System.out.println("O pedido atual é do tipo: " + pedido.getClass().getSimpleName());
                    }
                    break;

                case 3:
                    if (pedido != null) {
                        System.out.println("\n--- DADOS DO PEDIDO ---");
                        pedido.exibirDados();
                    } else {
                        System.out.println("Nenhum pedido cadastrado!");
                    }
                    break;

                case 4:
                    if (pedido != null) {
                        System.out.println("\nFormas de pagamento disponíveis:");
                        System.out.println("Opção 5: Dinheiro");
                        System.out.println("Opção 6: PIX");
                        System.out.println("Opção 7: Cartão");
                    } else {
                        System.out.println("Cadastre um pedido antes de escolher a forma de pagamento.");
                    }
                    break;

                case 5:
                    if (pedido != null) {
                        pedido.pagar(pedido.getValorPedido());
                    } else {
                        System.out.println("Nenhum pedido cadastrado!");
                    }
                    break;

                case 6:
                    if (pedido != null) {
                        System.out.print("Informe a chave PIX: ");
                        String chave = scanner.nextLine();
                        pedido.pagar(pedido.getValorPedido(), chave);
                    } else {
                        System.out.println("Nenhum pedido cadastrado!");
                    }
                    break;

                case 7:
                    if (pedido != null) {
                        System.out.print("Informe a quantidade de parcelas: ");
                        int parcelas = scanner.nextInt();
                        pedido.pagar(pedido.getValorPedido(), parcelas);
                    } else {
                        System.out.println("Nenhum pedido cadastrado!");
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