import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Informe o nome do cliente");
        String nome = sc.nextLine();
        
        
        Cliente cliente = new Cliente(nome);
        cliente.mostrarDados();
        
        System.out.println("Informe o nome do Produto");
        String produto = sc.nextLine();
        
        
        System.out.println("Informe a quantidade do Produto");
        int quantidade = sc.nextInt();
        
        
        System.out.println("Informe o valor do Produto");
        double valor = sc.nextDouble();


        System.out.println("\n<<<<COMPRAS>>>>");
        cliente.comprar(produto);
        System.out.println();
        
        cliente.comprar(produto, quantidade);
        System.out.println();
        
        cliente.comprar(produto, quantidade, valor);
        double total = quantidade *valor;
        


        System.out.println("=====PAGAMENTO=====");
        cliente.pagar(total);
        

        sc.close();
    }
}
