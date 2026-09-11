public class Tecnico extends Funcionario{
    private String setor;
    //construtor
    public Tecnico(String nome, double salario, String setor){
        super(nome, salario);
        this.setor = setor;
    }


    //getters
    public String getSetor(){
        return setor;

    }

    public void serSetor(String setor){
        this.setor = setor;
    }

@Override 
public void exibirDados(){
    super.exibirDados();
    System.out.println("Setor: " +setor);
}


}


