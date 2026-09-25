public class ProdutoDigital extends Produto {
    public ProdutoDigital(int codigo, String nome, double preco) {
        super(codigo, nome, preco);
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Produto Digital (Sem taxa de frete)");
    }
}