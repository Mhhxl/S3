import javax.swing.JOptionPane;

public class CaixaConfirmacao {

    public static void main(String[] args){

        int resposta=JOptionPane.showConfirmDialog(null, "Deseja continuar?",
        "Confirmaçao",JOptionPane.YES_NO_OPTION);


        if(resposta==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Voce clicou em sim",
            "resposta",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Voce clicou em nao",
            "resposta",JOptionPane.WARNING_MESSAGE);
        }

    }
    
}
