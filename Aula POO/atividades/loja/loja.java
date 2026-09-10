package atividades.loja;

public class loja {
    private String nome;
    private Double preco;
    private int quantidade;


    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome; 
    }

    public double getPreco(){
        return preco;

    }


    public void setPreco(Double preco){
        this.preco = preco;
    }


    public int getQuantidade(){
        return quantidade;
    }


    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}

