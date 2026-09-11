// essa daqui é a classe pai, basicamente todas as outras classes q eu for criar vai herdar isso daqui pra colocar coisas novas dentro delas mas sem alterar oq essa classe tem por si só
public class Veiculo{
    private String marca;
    private int ano;



    public String getMarca(){
        return marca;
    }



    public void setMarca(String marca){
        this.marca = marca;
    }




    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
        
    }


    public void exibirInfo(){
        System.out.println("Marca :" +marca);
        System.out.println("Ano :" +ano);
    }
}
