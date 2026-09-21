public class ContaCorrente extends Conta implements Pagamento {

    public ContaCorrente(String numeroConta, String titular, double saldoInicial, Agencia agencia) {
        super(numeroConta, titular, saldoInicial, agencia);
    }

    // Validação genérica de pagamento
    private boolean validarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero.");
            return false;
        }
        if (valor > getSaldo()) {
            System.out.println("Erro: Saldo insuficiente para realizar a operação.");
            return false;
        }
        return true;
    }

    // 1. Pagamento em Dinheiro (Implementação da Interface)
    @Override
    public boolean pagar(double valor) {
        if (!validarPagamento(valor)) {
            return false;
        }
        setSaldo(getSaldo() - valor);
        System.out.println("Pagamento em dinheiro efetuado com sucesso!");
        System.out.printf("Saldo atualizado: R$ %.2f\n", getSaldo());
        return true;
    }

    // 2. Pagamento via PIX (Sobrecarga: Valor + Chave PIX)
    public boolean pagar(double valor, String chavePix) {
        if (!validarPagamento(valor)) {
            return false;
        }
        setSaldo(getSaldo() - valor);
        System.out.println("Pagamento via PIX enviado com sucesso!");
        System.out.println("Chave PIX utilizada: " + chavePix);
        System.out.printf("Saldo atualizado: R$ %.2f\n", getSaldo());
        return true;
    }

    // 3. Pagamento no Cartão (Sobrecarga: Valor + Quantidade de Parcelas)
    public boolean pagar(double valor, int parcelas) {
        if (parcelas <= 0) {
            System.out.println("Erro: A quantidade de parcelas deve ser maior que zero.");
            return false;
        }
        if (!validarPagamento(valor)) {
            return false;
        }

        double valorParcela = valor / parcelas;
        setSaldo(getSaldo() - valor);
        System.out.println("Pagamento com cartão efetuado com sucesso!");
        System.out.printf("Compra dividida em %dx de R$ %.2f\n", parcelas, valorParcela);
        System.out.printf("Saldo atualizado: R$ %.2f\n", getSaldo());
        return true;
    }

    // Método do Desafio: Transferência bancária
    public boolean transferir(double valor, String contaDestino) {
        if (!validarPagamento(valor)) {
            return false;
        }
        setSaldo(getSaldo() - valor);
        System.out.printf("Transferência de R$ %.2f para a conta %s realizada com sucesso!\n", valor, contaDestino);
        System.out.printf("Saldo atualizado: R$ %.2f\n", getSaldo());
        return true;
    }
}