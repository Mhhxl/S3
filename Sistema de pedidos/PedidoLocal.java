public class PedidoLocal extends Pedido {
    public PedidoLocal(int numeroPedido, String nomeCliente, double valorPedido) {
        super(numeroPedido, nomeCliente, valorPedido);
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Pedido Local");
    }
}