import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class Ex05 {
    public static void main(String[] args) {
        
        ArrayList<String> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op = 1;

        while (op != 0) {
            try{
                System.out.println("1- Adicionar");
                System.out.println("2- Listar");
                System.out.println("3- Remover");
                System.out.println("0- Sair");
                System.out.println("informe a opção");
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        System.out.println("informe o nome: ");
                        String nome = sc.nextLine();
                        lista.add(nome);
                        System.out.println("Nome adicionado com Sucesso! ");
                        
                        break;
                    case 2:
                        if (lista.isEmpty()){
                            System.out.println("Lista vazia!");
                            
                        }else{
                            System.out.println("Lista =" +lista);
                            
                        }
                        break;
                    case 3:
                        System.out.println("Informe o indice para remover");
                        int remover_indice = sc.nextInt();
                        lista.remove(remover_indice);
                        System.out.println("Removido com sucesso!");
                        break;
                        
                        
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            }catch(InputMismatchException e){
                System.out.println("Erro: você deve digitar um número! ");
                sc.nextLine();
            }catch(IndexOutOfBoundsException e ){
                System.out.println("Erro: indice inválido! ");
                sc.nextLine();
                
            }catch(Exception e ){
                System.out.println("Erro inesperado " +e.getMessage());
            }
        }

        sc.close();
    }
}
