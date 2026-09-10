package atividades.cliente;

public class ClientePJ extends cliente{
    private String cnpj;

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;

    }

@Override 
public void exibirDados(){
    super.exibirDados();
    System.out.println("CNPJ: " +cnpj);
}


}
