public abstract class Pedido implements Pagamento {
    private int numeroPedido;
    private String nomeCliente;
    private double valorPedido;

    public Pedido(int numeroPedido, String nomeCliente, double valorPedido) {
        this.numeroPedido = numeroPedido;
        this.nomeCliente = nomeCliente;
        this.valorPedido = valorPedido;
    }

    // Getters e Setters (Encapsulamento)
    public int getNumeroPedido() { return numeroPedido; }
    public void setNumeroPedido(int numeroPedido) { this.numeroPedido = numeroPedido; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public double getValorPedido() { return valorPedido; }
    public void setValorPedido(double valorPedido) { this.valorPedido = valorPedido; }

    // Implementação da sobrecarga de métodos da interface Pagamento
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " realizado em DINHEIRO.");
    }

    @Override
    public void pagar(double valor, String chavePix) {
        System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " realizado via PIX (Chave: " + chavePix + ").");
    }

    @Override
    public void pagar(double valor, int parcelas) {
        double valorParcela = valor / parcelas;
        System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " realizado no CARTÃO em " 
                           + parcelas + "x de R$ " + String.format("%.2f", valorParcela) + ".");
    }

    public void exibirDados() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Valor do Pedido: R$ " + String.format("%.2f", valorPedido));
    }
}