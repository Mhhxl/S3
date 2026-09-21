public class Conta {
    private String numeroConta;
    private String titular;
    private double saldo;
    private Agencia agencia;

    public Conta(String numeroConta, String titular, double saldoInicial, Agencia agencia) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0;
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    // Depósito com validação (apenas valores > 0)
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.printf("Depósito realizado com sucesso! Novo saldo: R$ %.2f\n", this.saldo);
            return true;
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
            return false;
        }
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f\n", this.saldo);
    }

    public void mostrarDados() {
        System.out.println("\n--- DADOS DA CONTA ---");
        if (agencia != null) {
            agencia.mostrarDados();
        }
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo Atual: R$ %.2f\n", saldo);
        System.out.println("----------------------");
    }
}