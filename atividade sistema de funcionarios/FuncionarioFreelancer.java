public class FuncionarioFreelancer extends Funcionario {
    private int horasTrabalhadas;
    private double valorPorHora;

    public FuncionarioFreelancer(String nome, String cpf, int horasTrabalhadas, double valorPorHora) {
        super(nome, cpf, 0); // Salário base não se aplica diretamente
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorPorHora;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return (horasTrabalhadas * valorPorHora) + bonus;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- Dados do Funcionário Freelancer ---");
        super.exibirDados();
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.printf("Valor por Hora: R$ %.2f\n", valorPorHora);
    }
}