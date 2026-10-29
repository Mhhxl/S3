package br.com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.example.conexao.Conexao;
import br.com.example.modelo.Produto;

public class ProdutoDAO {
    
    public  boolean cadastrar(Produto produto){
        String sql = "INSERT INTO produtos(codigo, nome,preco) VALUES(?,?,?)";

        try (Connection conexao = Conexao.conectar();
    PreparedStatement comando = conexao.prepareStatement(sql)){
        comando.setInt(1,produto.getCodigo());
        comando.setString(2,produto.getNome());
        comando.setDouble(3,produto.getPreco());
        comando.executeUpdate();
        return  true;
    }catch(SQLException e){
        System.out.println("Erro ao cadastrar: "+e.getMessage());
        return false;
    }
    }
    public ArrayList<Produto> listar(){
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT codigo, nome, preco FROM produtos ORDER BY codigo";
        
        try(Connection conexao = Conexao.conectar();PreparedStatement 
        comando=conexao.prepareStatement(sql);
    ResultSet resultado=comando.executeQuery()){
        while (resultado.next()) {
            Produto produto=new Produto();
            produto.setCodigo(resultado.getInt("codigo"));
            produto.setNome(resultado.getString("nome"));
            produto.setPreco(resultado.getDouble("preco"));
            produtos.add(produto);
        }
    }catch(SQLException e){
        System.out.println("Erro ao listar: "+e.getMessage());
    }
    return produtos;
    }

    public Produto buscar(int codigo){
        String sql= "SELECT codigo, nome,preco FROM produtos WHERE codigo=?";

        try(Connection conexao=Conexao.conectar();
    PreparedStatement comando=conexao.prepareStatement(sql)){
        comando.setInt(1,codigo);
        try(ResultSet resultado=comando.executeQuery()){
            if (resultado.next()) {
                return new Produto(resultado.getInt("codigo"),
                resultado.getString("nome"),resultado.getDouble("preco"));
            }
        }
    }catch(SQLException e){
        System.out.println("Erro ao buscar"+e.getMessage());
    }
    return null;
    }
    public boolean alterar(int codigo, String nome, double preco){
        String sql="UPADTE produtos SET nome=?, preco=? WHERE codigo=?";

        try(Connection conexao=Conexao.conectar();
    PreparedStatement comando=conexao.prepareStatement(sql)){
        comando.setString(1,nome);
        comando.setDouble(2, preco);
        comando.setInt(3, codigo);
        return comando.executeUpdate()>0;
    }catch(SQLException e){
        System.out.println("Erro ao alterar"+e.getMessage());
        return false;
    }
    }

    public boolean remover(int codigo){
        String sql="DELETE FROM  produtos WHERE codigo=?";

        try(Connection conexao=Conexao.conectar();
    PreparedStatement comando=conexao.prepareStatement(sql)){
        comando.setInt(1, codigo);
        return comando.executeUpdate()>0;

    }catch(SQLException e){
        System.out.println("Erro ao remover"+e.getMessage());
        return false;
    }
    }

}
