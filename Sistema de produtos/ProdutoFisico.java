public class ProdutoFisico extends Produto {
    private double frete;

    public ProdutoFisico(int codigo, String nome, double preco, double frete) {
        super(codigo, nome, preco);
        this.frete = frete;
    }

    public double getFrete() { return frete; }
    public void setFrete(double frete) { this.frete = frete; }

    @Override
    public double realizarVenda(int quantidade) {
        
        return super.realizarVenda(quantidade) + frete;
    }

    @Override
    public double realizarVenda(int quantidade, double percentualDesconto) {
        
        double subtotalComDesconto = super.realizarVenda(quantidade, percentualDesconto);
        return subtotalComDesconto + frete;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Produto Físico");
        System.out.println("Frete: R$ " + String.format("%.2f", frete));
    }
}