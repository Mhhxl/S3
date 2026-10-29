package br.com.example.controle;

import java.util.ArrayList;

import br.com.example.dao.ProdutoDAO;
import br.com.example.modelo.Produto;

public class ProdutoControle {
    
    private ProdutoDAO dao;

    public ProdutoControle(){
        dao = new ProdutoDAO();

    }

    public boolean cadastrar(int codigo, String nome, double preco){
        Produto produto =new Produto(codigo, nome,preco);
        return dao.cadastrar(produto);
    }
    public ArrayList<Produto> listar(){
        return dao.listar();
    }

    public Produto buscar(int codigo){
        return dao.buscar(codigo);
    }

    public boolean alterar(int codigo,String nome, double preco){
        return dao.alterar(codigo, nome, preco);
    }
    public  boolean remover(int codigo){
        return dao.remover(codigo);
    }
}
