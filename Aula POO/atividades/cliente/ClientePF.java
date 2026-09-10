package atividades.cliente;

public class ClientePF extends cliente{
    private  String cpf;

    public ClientePF(String nome, String endereco, String cpf){
        super(nome,endereco);
        this.cpf = cpf;
    }


    public void exibirDados(){
        super.exibirDados;
        System.out.println("CPF: " +cpf );
    }
    
}
