package View;

import Controller.LoginController;
import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private LoginController controller;

    public TelaLogin() {
        controller = new LoginController();
        setTitle("Acesso ao Sistema");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("  Usuário:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("  Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        btnEntrar = new JButton("Entrar");
        add(new JLabel());
        add(btnEntrar);

        btnEntrar.addActionListener(e -> efetuarLogin());
    }

    private void efetuarLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());

        if (controller.autenticar(usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            new TelaProduto().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}