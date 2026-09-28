import java.util.Scanner;
public class Ex04 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Digite o nome :");
            String nome = sc.nextLine();
            if (nome.trim().isEmpty()){
                throw new Exception("o campo nome não pode ser vazio");
            }
            System.out.println("O nome digitado é: " +nome);
        }catch( Exception e){
            System.out.println("Erro! " +e.getMessage());
        }
    }
}
