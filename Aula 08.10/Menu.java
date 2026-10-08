import java.util.ArrayList;

import javax.swing.JOptionPane;
public class Menu {
    public static void main(String[] args) {
        
        ArrayList<String> produtos = new ArrayList<>();

        boolean executado = true;


        while (executado) {
            String opcao = JOptionPane.showInputDialog(
                
                "Escolha uma opção : \n"+
                "1- Cadastrar Produtos"+
                "2- Listar produtos"+
                "3- Sair",
                JOptionPane.QUESTION_MESSAGE
            );

            if (opcao == null){
                JOptionPane.showMessageDialog(null, "Operação cancelada");
                break;
            }
            switch (opcao) {
                case "1":
                    String produto = JOptionPane.showInputDialog(null,
                        "Digite o nome do produto",
                        "Cadastro do Produto",
                        JOptionPane.QUESTION_MESSAGE
                    );
                    
                    break;
            
                default:
                    break;
            }
        }
    }

}

