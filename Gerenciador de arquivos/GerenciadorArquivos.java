import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GerenciadorArquivos {
  
    private static final String DIRETORIO_BASE = "LABORATORIO";

    public static void main(String[] args) {
        File pastaBase = new File(DIRETORIO_BASE);
        if (!pastaBase.exists()) {
            pastaBase.mkdir();
        }

        int opcao = 0;

        do {
            String menu = "=== GERENCIADOR DE ARQUIVOS - LABORATORIO ===\n\n"
                        + "1 - Criar pasta\n"
                        + "2 - Criar arquivo\n"
                        + "3 - Escrever no arquivo\n"
                        + "4 - Ler arquivo\n"
                        + "5 - Renomear arquivo\n"
                        + "6 - Excluir arquivo\n"
                        + "7 - Mostrar informações do arquivo\n"
                        + "8 - Proteger arquivo (Somente Leitura) [Desafio]\n"
                        + "9 - Sair\n\n"
                        + "Escolha uma opção:";

            String entrada = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);

            // Tratamento para cancelamento ou fechamento da janela
            if (entrada == null) {
                break;
            }

            try {
                opcao = Integer.parseInt(entrada);

                switch (opcao) {
                    case 1:
                        criarPasta();
                        break;
                    case 2:
                        criarArquivo();
                        break;
                    case 3:
                        escreverNoArquivo();
                        break;
                    case 4:
                        lerArquivo();
                        break;
                    case 5:
                        renomearArquivo();
                        break;
                    case 6:
                        excluirArquivo();
                        break;
                    case 7:
                        mostrarInformacoes();
                        break;
                    case 8:
                        protegerArquivo();
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null, "Encerrando o sistema...", "Sair", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida! Escolha um número de 1 a 9.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, informe apenas números inteiros.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcao != 9);
    }

    // 2. Criar pasta
    private static void criarPasta() {
        String nomePasta = solicitarNomeValido("Digite o nome da pasta a ser criada dentro de LABORATORIO:");
        if (nomePasta == null) return;

        File novaPasta = new File(DIRETORIO_BASE, nomePasta);

        if (novaPasta.exists()) {
            JOptionPane.showMessageDialog(null, "A pasta '" + nomePasta + "' já existe no diretório LABORATORIO.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            if (novaPasta.mkdirs()) {
                JOptionPane.showMessageDialog(null, "Pasta '" + nomePasta + "' criada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao criar a pasta.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 3. Criar arquivo
    private static void criarArquivo() {
        String nomeArquivo = solicitarNomeValido("Digite o nome do arquivo com extensão (ex: atividade.txt):");
        if (nomeArquivo == null) return;

        File arquivo = new File(DIRETORIO_BASE, nomeArquivo);

        if (arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' já existe!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (arquivo.createNewFile()) {
                    JOptionPane.showMessageDialog(null, "Arquivo '" + nomeArquivo + "' criado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao criar arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // 4. Escrever no arquivo
    private static void escreverNoArquivo() {
        String nomeArquivo = solicitarNomeValido("Digite o nome do arquivo onde deseja escrever:");
        if (nomeArquivo == null) return;

        File arquivo = new File(DIRETORIO_BASE, nomeArquivo);

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!arquivo.canWrite()) {
            JOptionPane.showMessageDialog(null, "Permissão negada! O arquivo está protegido contra gravação.", "Erro de Permissão", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String texto = JOptionPane.showInputDialog(null, "Digite o texto que deseja gravar no arquivo:", "Escrever", JOptionPane.QUESTION_MESSAGE);
        if (texto == null) return; // Cancelado

        try {
            // Escreve adicionando uma nova linha ao final (append)
            Files.writeString(arquivo.toPath(), texto + System.lineSeparator(), StandardOpenOption.APPEND);
            JOptionPane.showMessageDialog(null, "Conteúdo gravado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao escrever no arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 5. Ler arquivo
    private static void lerArquivo() {
        String nomeArquivo = solicitarNomeValido("Digite o nome do arquivo que deseja ler:");
        if (nomeArquivo == null) return;

        File arquivo = new File(DIRETORIO_BASE, nomeArquivo);

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String conteudo = Files.readString(arquivo.toPath());
            if (conteudo.isEmpty()) {
                conteudo = "[O arquivo está vazio]";
            }
            JOptionPane.showMessageDialog(null, "=== Conteúdo de " + nomeArquivo + " ===\n\n" + conteudo, "Leitura de Arquivo", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 6. Renomear arquivo
    private static void renomearArquivo() {
        String nomeAtual = solicitarNomeValido("Digite o nome atual do arquivo/pasta:");
        if (nomeAtual == null) return;

        File arquivoAtual = new File(DIRETORIO_BASE, nomeAtual);

        if (!arquivoAtual.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeAtual + "' não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String novoNome = solicitarNomeValido("Digite o NOVO nome:");
        if (novoNome == null) return;

        File novoArquivo = new File(DIRETORIO_BASE, novoNome);

        if (novoArquivo.exists()) {
            JOptionPane.showMessageDialog(null, "Já existe um arquivo ou pasta com o nome '" + novoNome + "'!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (arquivoAtual.renameTo(novoArquivo)) {
            JOptionPane.showMessageDialog(null, "Arquivo renomeado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao renomear o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 7. Excluir arquivo
    private static void excluirArquivo() {
        String nomeArquivo = solicitarNomeValido("Digite o nome do arquivo que deseja excluir:");
        if (nomeArquivo == null) return;

        File arquivo = new File(DIRETORIO_BASE, nomeArquivo);

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            null,
            "Tem certeza que deseja excluir o arquivo '" + nomeArquivo + "'?",
            "Confirmação de Exclusão",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            if (arquivo.delete()) {
                JOptionPane.showMessageDialog(null, "Arquivo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível excluir o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação de exclusão cancelada.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // 8. Mostrar informações do arquivo
    private static void mostrarInformacoes() {
        String nomeArquivo = solicitarNomeValido("Digite o nome do arquivo para ver as informações:");
        if (nomeArquivo == null) return;

        File arquivo = new File(DIRETORIO_BASE, nomeArquivo);

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Extrai a extensão do arquivo
        String extensao = "";
        int i = nomeArquivo.lastIndexOf('.');
        if (i > 0) {
            extensao = nomeArquivo.substring(i + 1);
        } else {
            extensao = "Sem extensão / Diretório";
        }

        // Formatação da data de modificação
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataModificacao = sdf.format(new Date(arquivo.lastModified()));

        String info = "=== INFORMAÇÕES DO ARQUIVO ===\n\n"
                    + "Nome: " + arquivo.getName() + "\n"
                    + "Extensão: " + extensao + "\n"
                    + "Tamanho: " + arquivo.length() + " bytes\n"
                    + "Caminho Completo: " + arquivo.getAbsolutePath() + "\n"
                    + "Permissão de Leitura: " + (arquivo.canRead() ? "Sim" : "Não") + "\n"
                    + "Permissão de Gravação: " + (arquivo.canWrite() ? "Sim" : "Não") + "\n"
                    + "Permissão de Execução: " + (arquivo.canExecute() ? "Sim" : "Não") + "\n"
                    + "Última Modificação: " + dataModificacao;

        JOptionPane.showMessageDialog(null, info, "Informações do Arquivo", JOptionPane.INFORMATION_MESSAGE);
    }

    // Desafio Complementar: Proteção de Arquivo (Somente Leitura)
    private static void protegerArquivo() {
        String nomeArquivo = solicitarNomeValido("Digite o nome do arquivo que deseja tornar SOMENTE LEITURA:");
        if (nomeArquivo == null) return;

        File arquivo = new File(DIRETORIO_BASE, nomeArquivo);

        if (!arquivo.exists()) {
            JOptionPane.showMessageDialog(null, "O arquivo '" + nomeArquivo + "' não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (arquivo.setReadOnly()) {
            JOptionPane.showMessageDialog(
                null,
                "Arquivo definido como SOMENTE LEITURA com sucesso!\n" +
                "Verifique a opção 7 para confirmar a alteração na permissão de gravação.",
                "Desafio Concluído",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar as permissões do arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método utilitário para validar se o nome não é vazio e tratar o cancelamento
    private static String solicitarNomeValido(String mensagem) {
        String entrada = JOptionPane.showInputDialog(null, mensagem, "Entrada de Dados", JOptionPane.QUESTION_MESSAGE);
        
        if (entrada == null) {
            return null; 
        }

        entrada = entrada.trim();

        if (entrada.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O nome não pode ser vazio!", "Validação", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        return entrada;
    }
}