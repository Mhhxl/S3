package atividade;
import java.util.Scanner;
public class atv5 {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite o número que deseja pra tabuada: ");
        int num = ler.nextInt();

        for (int i = 1; i <= 10; i ++){
            System.out.println("A tábuada do número " +num + " é: " );
            
            System.out.println(+num + " X " +i + " = " + (num * i  ));
        }


        ler.close();
        

    }
    
}
