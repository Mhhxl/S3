import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Carro> listaCarros = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 0;

        do {
            String menu = "=== SISTEMA DE CADASTRO DE CARROS ===\n"
                        + "1 - Cadastrar Carro\n"
                        + "2 - Listar Carros\n"
                        + "3 - Detalhar Carro\n"
                        + "4 - Alterar Carro\n"
                        + "5 - Remover Carro\n"
                        + "6 - Gravar Informações em Arquivo\n"
                        + "7 - Sair\n\n"
                        + "Escolha uma opção:";

            String entrada = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);

            if (entrada == null) {
                break; 
            }

            try {
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        cadastrarCarro();
                        break;
                    case 2:
                        listarCarros();
                        break;
                    case 3:
                        detalharCarro();
                        break;
                    case 4:
                        alterarCarro();
                        break;
                    case 5:
                        removerCarro();
                        break;
                    case 6:
                        gravarEmArquivo();
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Saindo do sistema...", "Encerrando", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número de 1 a 7.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcao != 7);
    }

    private static void cadastrarCarro() {
        String marca = JOptionPane.showInputDialog(null, "Informe a Marca do carro:", "Cadastrar Carro", JOptionPane.QUESTION_MESSAGE);
        if (marca == null || marca.trim().isEmpty()) return;

        String modelo = JOptionPane.showInputDialog(null, "Informe o Modelo do carro:", "Cadastrar Carro", JOptionPane.QUESTION_MESSAGE);
        if (modelo == null || modelo.trim().isEmpty()) return;

        try {
            String anoStr = JOptionPane.showInputDialog(null, "Informe o Ano do carro:", "Cadastrar Carro", JOptionPane.QUESTION_MESSAGE);
            if (anoStr == null) return;
            int ano = Integer.parseInt(anoStr);

            Carro carro = new Carro(marca, modelo, ano);
            listaCarros.add(carro);

            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano inválido! O cadastro foi cancelado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listarCarros() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.", "Lista de Carros", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder lista = new StringBuilder("=== CARROS CADASTRADOS ===\n\n");
        for (int i = 0; i < listaCarros.size(); i++) {
            Carro c = listaCarros.get(i);
            lista.append(i + 1).append(" - Marca: ").append(c.getMarca()).append(" | Modelo: ").append(c.getModelo()).append("\n");
        }

        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Carros", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void detalharCarro() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int indice = selecionarIndiceCarro("Selecione o número do carro para ver os detalhes:");
        if (indice != -1) {
            Carro c = listaCarros.get(indice);
            JOptionPane.showMessageDialog(null, c.exibirDetalhes(), "Detalhes do Carro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterarCarro() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int indice = selecionarIndiceCarro("Selecione o número do carro que deseja alterar:");
        if (indice != -1) {
            Carro c = listaCarros.get(indice);

            String novaMarca = JOptionPane.showInputDialog(null, "Nova Marca:", c.getMarca());
            if (novaMarca == null || novaMarca.trim().isEmpty()) return;

            String novoModelo = JOptionPane.showInputDialog(null, "Novo Modelo:", c.getModelo());
            if (novoModelo == null || novoModelo.trim().isEmpty()) return;

            try {
                String novoAnoStr = JOptionPane.showInputDialog(null, "Novo Ano:", c.getAno());
                if (novoAnoStr == null) return;
                int novoAno = Integer.parseInt(novoAnoStr);

                c.setMarca(novaMarca);
                c.setModelo(novoModelo);
                c.setAno(novoAno);

                JOptionPane.showMessageDialog(null, "Dados do carro atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ano inválido! A alteração foi cancelada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void removerCarro() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum carro cadastrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int indice = selecionarIndiceCarro("Selecione o número do carro que deseja remover:");
        if (indice != -1) {
            Carro removido = listaCarros.remove(indice);
            JOptionPane.showMessageDialog(null, "Carro " + removido.getModelo() + " removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void gravarEmArquivo() {
        if (listaCarros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há carros cadastrados para gravar no arquivo.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (FileWriter fw = new FileWriter("carros.txt");
            PrintWriter pw = new PrintWriter(fw)) {

            for (Carro c : listaCarros) {
                pw.println("Marca: " + c.getMarca());
                pw.println("Modelo: " + c.getModelo());
                pw.println("Ano: " + c.getAno());
                pw.println("-----------------------------------");
            }

            JOptionPane.showMessageDialog(null, "Informações gravadas com sucesso no arquivo 'carros.txt'!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo: " + e.getMessage(), "Erro de E/S", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static int selecionarIndiceCarro(String mensagem) {
        StringBuilder sb = new StringBuilder(mensagem + "\n\n");
        for (int i = 0; i < listaCarros.size(); i++) {
            sb.append(i + 1).append(" - ").append(listaCarros.get(i).getMarca()).append(" ").append(listaCarros.get(i).getModelo()).append("\n");
        }

        String entrada = JOptionPane.showInputDialog(null, sb.toString(), "Escolha de Carro", JOptionPane.QUESTION_MESSAGE);
        if (entrada == null) return -1;

        try {
            int num = Integer.parseInt(entrada);
            if (num >= 1 && num <= listaCarros.size()) {
                return num - 1; 
            } else {
                JOptionPane.showMessageDialog(null, "Número inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }
}