// classe main pra rodar tudo
public class Main {
    public static void main(String[] args){
        // criando carro
        Carro c = new Carro();
        c.setMarca("Toyota");
        c.setAno(2015);
        c.setQuantidadePortas(4);

        System.out.println("DADOS DO CARRO");
        c.exibirInfo();
        System.out.println();
        
        //criando moto
        Moto m = new Moto();
        m.setAno(2020);
        m.setMarca("Yamaha");
        m.setCilindrada(200);
        
        System.out.println("DADOS DA MOTO");
        m.exibirInfo();
        System.out.println();





    }
}
