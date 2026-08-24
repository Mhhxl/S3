import java.util.Scanner;
public class ex05 {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        for (int i = 1; i <= 3; i++){
            System.out.println("informe o " + i +" º nome :");
            String nome = ler.nextLine();
            System.out.println("O nome cadastrado é  = " + nome );

            

        }
        ler.close();
    }
}
