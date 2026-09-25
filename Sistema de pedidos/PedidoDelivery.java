public class PedidoDelivery extends Pedido {
    private String endereco;
    private double taxaEntrega;

    public PedidoDelivery(int numeroPedido, String nomeCliente, double valorPedido, String endereco, double taxaEntrega) {
        super(numeroPedido, nomeCliente, valorPedido);
        this.endereco = endereco;
        this.taxaEntrega = taxaEntrega;
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public double getTaxaEntrega() { return taxaEntrega; }
    public void setTaxaEntrega(double taxaEntrega) { this.taxaEntrega = taxaEntrega; }

    @Override
    public double getValorPedido() {
        return super.getValorPedido() + taxaEntrega;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Pedido Delivery");
        System.out.println("Endereço: " + endereco);
        System.out.println("Taxa de Entrega: R$ " + String.format("%.2f", taxaEntrega));
        System.out.println("Valor Total (com taxa): R$ " + String.format("%.2f", getValorPedido()));
    }
}