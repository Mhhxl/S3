public class Carro extends Veiculo {

    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public String exibirDetalhes() {
        return "=== Detalhes do Carro ===\n" + super.exibirDetalhes();
    }
}