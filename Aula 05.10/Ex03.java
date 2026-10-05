import java.io.File;
import java.io.FileNotFoundException;
import  java.util.Scanner;
public class Ex03 {
    public static void main(String[] args) {
        try{
            File arquivo = new File("Exemplo.txt");
            Scanner sc = new  Scanner(System.in);
            while (sc.hasNextLine()) {
                String linha =  sc.nextLine();
                System.out.println(linha);

            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }
        }
    }

