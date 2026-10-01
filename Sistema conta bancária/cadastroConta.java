import java.util.ArrayList;
import java.util.List;

public class cadastroConta {
    private List<Conta> contas;
    private static final int LIMITE_MAXIMO = 100;

    public cadastroConta() {
        this.contas = new ArrayList<>();
    }

    public void inserir(Conta conta) throws ExcecaoRepositorio, ExcecaoElementoJaExistente {
        if (contas.size() >= LIMITE_MAXIMO) {
            throw new ExcecaoRepositorio(
                "Limite máximo de " + LIMITE_MAXIMO + " contas atingido."
            );
        }

        for (Conta c : contas) {
            if (c.getNumero().equalsIgnoreCase(conta.getNumero())) {
                throw new ExcecaoElementoJaExistente(
                    "Já existe uma conta com o número informado."
                );
            }
        }

        contas.add(conta);
    }

    public Conta buscar(String numero) throws ExcecaoElementoInexistente {
        for (Conta c : contas) {
            if (c.getNumero().equalsIgnoreCase(numero)) {
                return c;
            }
        }

        throw new ExcecaoElementoInexistente(
            "Conta não encontrada para o número: " + numero
        );
    }

    public void remover(String numero) throws ExcecaoElementoInexistente {
        Conta conta = buscar(numero);
        contas.remove(conta);
    }
}
