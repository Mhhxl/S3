public interface Pagamento {
    double calcularPagamento();
    double calcularPagamento(double bonus); // Sobrecarga com bónus
}