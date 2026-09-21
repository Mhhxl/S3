public class FuncionarioCLT extends Funcionario {

    public FuncionarioCLT(String nome, String cpf, double salarioMensal) {
        super(nome, cpf, salarioMensal);
    }

    @Override
    public double calcularPagamento() {
        return getSalario();
    }

    @Override
    public double calcularPagamento(double bonus) {
        return getSalario() + bonus;
    }

    @Override
    public void exibirDados() {
        System.out.println("\n--- Dados do Funcionário CLT ---");
        super.exibirDados();
        System.out.printf("Salário Mensal Base: R$ %.2f\n", getSalario());
    }
}