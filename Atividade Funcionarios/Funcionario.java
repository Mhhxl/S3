public class Funcionario{
    private String nome;
    private Double salario;

    // Isso é o construtor, ele recebe os dados no momento em que o objeto é criado
    public Funcionario(String nome , Double salario){
        this.nome = nome;
        this.salario = salario;
    }
    //Getters
    public String getNome(){
        return nome;
    }
    public Double getSalario(){
        return salario;
    }

    // Setters

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSalario(Double salario){
        this.salario = salario;
    }

    public void exibirDados(){
        System.out.println("Nome: " +nome);
        System.out.println("Salario: " +salario);

    }

}