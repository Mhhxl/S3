public abstract class Veiculo implements Aluguel {
    private String placa;
    private String modelo;
    private int ano;
    private double valorDiaria;

    public Veiculo(String placa, String modelo, int ano, double valorDiaria) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }

    
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(double valorDiaria) { this.valorDiaria = valorDiaria; }

    
    @Override
    public double calcularAluguel(int dias) {
        return this.valorDiaria * dias;
    }

    @Override
    public double calcularAluguel(int dias, double desconto) {
        return (this.valorDiaria * dias) - desconto;
    }

    public void exibirDados() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Valor da Diária: R$ " + String.format("%.2f", valorDiaria));
    }
}