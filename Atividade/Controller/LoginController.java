package Controller;

import DAO.UsuarioDAO;
import model.Usuario;

public class LoginController {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean autenticar(String login, String senha) {
        Usuario usuario = usuarioDAO.autenticar(login, senha);
        return usuario != null;
    }
}