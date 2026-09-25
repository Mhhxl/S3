public abstract class Produto implements Venda {
    private int codigo;
    private String nome;
    private double preco;

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    
    @Override
    public double realizarVenda(int quantidade) {
        return this.preco * quantidade;
    }

    @Override
    public double realizarVenda(int quantidade, double percentualDesconto) {
        double subtotal = this.realizarVenda(quantidade);
        return subtotal - (subtotal * (percentualDesconto / 100.0));
    }

    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Preço unitário: R$ " + String.format("%.2f", preco));
    }
}