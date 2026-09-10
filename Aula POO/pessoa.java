public class pessoa {
    // encapsular
    private int codigo;// o private serve pra dizer q apenas essa classe tem acesso a esse atributo
    private String nome;

    public  pessoa(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }



    public  int getCodigo(){
        return codigo;

    }

    public  void setCodigo(int codigo){
        this.codigo = codigo;

    }


    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}
