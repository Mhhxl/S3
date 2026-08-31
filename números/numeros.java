
import java.util.Scanner;
public class numeros{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];
        int contadorNumeros = 0;
        


        loopExterno1 :while (true) {

            System.out.println("==MENU==");
            System.out.println("");
            System.out.println("1- Inserir número");
            System.out.println("2- Listar números ");
            System.out.println("3- Remover número");
            System.out.println("4- Sair");
            System.out.print("O que deseja fazer? --->>> ");
            int opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    if ( contadorNumeros <= numeros.length ){
                        System.out.println("O limite de números foi atingido ");
                    }else{
                        System.out.print("Qual número gostaria de inserir? -->> ");
                        int inserirNumero = sc.nextInt();
                        sc.nextLine();
                        
                        numeros[contadorNumeros] =inserirNumero;
                        contadorNumeros ++;
                        System.out.println("Número inserido com sucesso !!");
                    }
    
                    break;
                    
                    case 2:
                        System.out.println("==LISTANDO==");
                        for (int i = 0; i < contadorNumeros; i++){
                            System.out.println(numeros[i]);
                            
                        }

                        break;
                        
                    case 3:
                        System.out.print("Qual número deseja remover? -->> ");
                        int removerNumero = sc.nextInt();

                    int posicao = -1;

                    // Procurar o número
                    for (int i = 0; i < contadorNumeros; i++) {
                        if (numeros[i] == removerNumero) {
                            posicao = i;



                            break;
                        }   
                        }   

                        // Verificar se encontrou
                        if (posicao == -1) {
                            System.out.println("Número não encontrado!");
                        } else {

                            // Puxar os números para a esquerda
                            for (int i = posicao; i < contadorNumeros - 1; i++) {
                                numeros[i] = numeros[i + 1];
                            }

                                contadorNumeros--;  

                                System.out.println("Número removido com sucesso!");
    }

    break;

                    
                        case 4:
                            System.out.println("Saindo...");
                            break;
                        
            }   


            break loopExterno1;
        }
        
        sc.close();

    }
}