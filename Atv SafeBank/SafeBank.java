import java.util.InputMismatchException;
import java.util.Scanner;
public class SafeBank{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    double saldo = 1000.00;
    System.out.println("===BEM VINDO AO SAFEBANK===");
    System.out.println("Saldo disponivel: R$"+saldo);
    try{
        System.out.println("Digite o valor que deseja sacar: ");
        double valorSaque = sc.nextDouble();

        if (valorSaque < 0){
            System.out.println("Erro: o valor do saque não pode ser negativo");

        }else if(valorSaque>saldo){
            System.out.println("Erro: Saldo insuficiente");
        }else{
            saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso");
            System.out.println("Novo saldo: R$" +saldo);

        }
    }catch(InputMismatchException e ){
        System.out.println("Erro crítico: entrada inválida! por favor, use apenas números e vírgula");
    }catch(Exception e ){
        System.out.println("Ocorreu um erro inesperado: "+e.getMessage());

    }finally{
        System.out.println("Operação concluida");
    }

    sc.close();

    }
}