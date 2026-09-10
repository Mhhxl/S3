public class exemploMetodo{
    public static void mensagem(){
        // sem parâmetro e sem retorno
        System.out.println("hello, World");

    }

    // com parâmetro e sem retorno
    public static void mostrarNome(String nome){
        System.out.println("nome " + nome );
    }
    // sem parametro e com retorno
    public static int obterNumero(){
        return 10;

    }

    // com parametro e com retorno
    public static int somar(int n1, int n2){
        return n1 + n2;

    }

    public static void main(String[] args){
        mensagem();
        mostrarNome( "carlos");
        int num = obterNumero();
        System.out.println("Número : " +num)
        int resultado = somar(10,5)
        System.out.println("Soma :" + resultado)
    }


}   
