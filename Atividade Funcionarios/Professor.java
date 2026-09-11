public class Professor extends Funcionario{
    private String disciplina;


    //tenho que fazer um construtor nas classes filhas quando a classe pai tiver uma também
    public  Professor(String nome, Double salario, String disciplina){
        super(nome, salario);
        this.disciplina = disciplina;
    }


    // getter
    public String getDisciplina(){
        return disciplina;
    }


    //setter
    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
    
@Override 
public void exibirDados(){
    super.exibirDados();
    System.out.println("Disciplina: "+disciplina);
    
}
}



