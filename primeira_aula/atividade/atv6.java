package atividade;
import java.util.Scanner;
public class atv6 {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        int op;
        do {

            System.out.println("====MENU====");
            System.out.println("1- calcular tabuada");
            System.out.println("2- contagem regressiva");
            System.out.println("0- sair");
            System.out.println("Escolha a opção:");
            op=ler.nextInt();
            
            switch (op) {
                case 1:
                    System.out.println("Digite o número = ");
                    int num = ler.nextInt();
                    for (int i = 1; i <= 10; i++){
                        System.out.println(num + " X " + i +"=" + (num*i ));
                        
                    }
                    case 2:
                        System.out.println("Digite o número = ");
                        num = ler.nextInt();
                        for (int i = num; i >= 0; i--){
                            System.out.println(i);
                            
                        }
                        break;
                        
                        
                        case 0: 
                        System.out.println("Saindo...");
                        break;
            }
            
        }
        
        
        ler.close();
    }
}
