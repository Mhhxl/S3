package DAO;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private static List<Produto> bancoDados = new ArrayList<>();

    public boolean salvar(Produto produto) {
        return bancoDados.add(produto);
    }

    public List<Produto> listar() {
        return new ArrayList<>(bancoDados);
    }

    public Produto buscarPorId(int id) {
        for (Produto p : bancoDados) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean atualizar(Produto produto) {
        for (int i = 0; i < bancoDados.size(); i++) {
            if (bancoDados.get(i).getId() == produto.getId()) {
                bancoDados.set(i, produto);
                return true;
            }
        }
        return false;
    }

    public boolean deletar(int id) {
        return bancoDados.removeIf(p -> p.getId() == id);
    }
}