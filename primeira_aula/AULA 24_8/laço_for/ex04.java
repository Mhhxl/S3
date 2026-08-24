import java.util.Scanner;

public class ex04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for (int i= 1; i<=3; i++){
            System.out.println("informe o " +i + "º número :");
            int num = sc.nextInt();
            System.out.println("O número informado é " +num);


            sc.close();
        }
    }
}
