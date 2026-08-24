


// tabuada 

import java.util.Scanner;
public class ex06 {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o número = ");
        int num = ler.nextInt();

        for (int i =1; i<=10; i++){
            System.out.println(num+ " X "+i+ " ="+(num*i) );

        }

        ler.close();

    }

    
}
