import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        try{
            System.out.println("Informe um numero inteiro");
            int num = sc.nextInt();
            System.out.println("Você digitou: " +num);
        }catch(InputMismatchException e){
            System.out.println("Erro, você deve digitar um número inteiro !");
            
        }
        finally{
            System.out.println("Fim do programa");

        }

        sc.close();
    }
}
