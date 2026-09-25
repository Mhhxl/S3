public class CursoOnline extends Curso {
    private String enderecoPlataforma;
    private String codigoAcesso;

    public CursoOnline(int codigo, String nome, int cargaHoraria, double valor, String enderecoPlataforma, String codigoAcesso) {
        super(codigo, nome, cargaHoraria, valor);
        this.enderecoPlataforma = enderecoPlataforma;
        this.codigoAcesso = codigoAcesso;
    }

    public String getEnderecoPlataforma() { return enderecoPlataforma; }
    public void setEnderecoPlataforma(String enderecoPlataforma) { this.enderecoPlataforma = enderecoPlataforma; }

    public String getCodigoAcesso() { return codigoAcesso; }
    public void setCodigoAcesso(String codigoAcesso) { this.codigoAcesso = codigoAcesso; }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Tipo: Online");
        System.out.println("Plataforma: " + enderecoPlataforma);
        System.out.println("Código de Acesso: " + codigoAcesso);
    }
}