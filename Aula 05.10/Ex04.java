import java.io.FileWriter;
import java.io.IOException;
public class Ex04 {
    public static void main(String[] args) {
        
        try{
            FileWriter fw = new  FileWriter("dado.txt");
            fw.write("Primeira linha"); 
            fw.write("Segunda linha"); 
            fw.write("Terceira linha"); 
            fw.close();
            System.out.println("Escrita concluida");
        }catch(IOException e ){
            e.printStackTrace();
        }
    }
}
