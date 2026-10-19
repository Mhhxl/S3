package View;

import Controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaProduto extends JFrame {
    private JTextField txtId, txtNome, txtCategoria, txtPreco, txtQuantidade;
    private JButton btnSalvar, btnAtualizar, btnExcluir, btnPesquisar, btnLimpar;
    private JTable tabela;
    private DefaultTableModel tableModel;
    private ProdutoController controller;

    public TelaProduto() {
        controller = new ProdutoController();
        setTitle("Gerenciamento de Produtos");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel de Formulário
        JPanel panelForm = new JPanel(new GridLayout(5, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Dados do Produto"));

        panelForm.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelForm.add(txtNome);

        panelForm.add(new JLabel("Categoria:"));
        txtCategoria = new JTextField();
        panelForm.add(txtCategoria);

        panelForm.add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        panelForm.add(txtPreco);

        panelForm.add(new JLabel("Quantidade:"));
        txtQuantidade = new JTextField();
        panelForm.add(txtQuantidade);

        add(panelForm, BorderLayout.NORTH);

        // Tabela
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Categoria", "Preço", "Qtd"}, 0);
        tabela = new JTable(tableModel);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botoes
        JPanel panelBotoes = new JPanel();
        btnSalvar = new JButton("Cadastrar");
        btnAtualizar = new JButton("Atualizar");
        btnExcluir = new JButton("Remover");
        btnPesquisar = new JButton("Pesquisar ID");
        btnLimpar = new JButton("Limpar/Listar");

        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnAtualizar);
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnPesquisar);
        panelBotoes.add(btnLimpar);

        add(panelBotoes, BorderLayout.SOUTH);

        // Ações dos botões
        btnSalvar.addActionListener(e -> cadastrar());
        btnAtualizar.addActionListener(e -> atualizar());
        btnExcluir.addActionListener(e -> remover());
        btnPesquisar.addActionListener(e -> pesquisar());
        btnLimpar.addActionListener(e -> { limparCampos(); atualizarTabela(); });

        atualizarTabela();
    }

    private void cadastrar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String cat = txtCategoria.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int qtd = Integer.parseInt(txtQuantidade.getText());

            if (controller.cadastrarProduto(id, nome, cat, preco, qtd)) {
                JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
                limparCampos();
                atualizarTabela();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Verifique os dados informados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            String cat = txtCategoria.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            int qtd = Integer.parseInt(txtQuantidade.getText());

            if (controller.atualizarProduto(id, nome, cat, preco, qtd)) {
                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
                limparCampos();
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado para atualização.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void remover() {
        try {
            int id = Integer.parseInt(txtId.getText());
            if (controller.removerProduto(id)) {
                JOptionPane.showMessageDialog(this, "Produto removido com sucesso!");
                limparCampos();
                atualizarTabela();
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID válido para remoção.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void pesquisar() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Produto p = controller.buscarPorId(id);
            if (p != null) {
                txtNome.setText(p.getNome());
                txtCategoria.setText(p.getCategoria());
                txtPreco.setText(String.valueOf(p.getPreco()));
                txtQuantidade.setText(String.valueOf(p.getQuantidade()));
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Informe um ID para pesquisa.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        List<Produto> lista = controller.listarProdutos();
        for (Produto p : lista) {
            tableModel.addRow(new Object[]{p.getId(), p.getNome(), p.getCategoria(), p.getPreco(), p.getQuantidade()});
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtCategoria.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
    }
}