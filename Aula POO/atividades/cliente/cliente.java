package atividades.cliente;

public class cliente {

    private  String nome;
    private  String endereco;
    public cliente(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;

    }

    public String getendereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }


    public String toString(){
        System.out.println("nome: "+nome);
        System.out.println("endereço: " +endereco);
    }








}

