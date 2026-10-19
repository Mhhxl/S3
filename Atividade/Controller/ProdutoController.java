package Controller;

import DAO.ProdutoDAO;
import model.Produto;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public boolean cadastrarProduto(int id, String nome, String categoria, double preco, int quantidade) {
        Produto p = new Produto(id, nome, categoria, preco, quantidade);
        return produtoDAO.salvar(p);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listar();
    }

    public Produto buscarPorId(int id) {
        return produtoDAO.buscarPorId(id);
    }

    public boolean atualizarProduto(int id, String nome, String categoria, double preco, int quantidade) {
        Produto p = new Produto(id, nome, categoria, preco, quantidade);
        return produtoDAO.atualizar(p);
    }

    public boolean removerProduto(int id) {
        return produtoDAO.deletar(id);
    }
}